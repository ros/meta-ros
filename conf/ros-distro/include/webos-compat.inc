# Copyright (c) 2019 LG Electronics, Inc.
#
# Place the fixups necessary to make meta-webosose compatible with meta-ros version 2 here.

# These will be "<unknown>" if TOPDIR isn't a Git repo => drop them from the display of the build configuration if this is the
# case.
BUILDCFG_VARS_remove = "${@oe.utils.conditional('WEBOS_DISTRO_TOPDIR_REVISION', '<unknown>', 'WEBOS_DISTRO_TOPDIR_REVISION', '', d)}"
BUILDCFG_VARS_remove = "${@oe.utils.conditional('WEBOS_DISTRO_TOPDIR_DESCRIBE', '<unknown>', 'WEBOS_DISTRO_TOPDIR_DESCRIBE', '', d)}"

# XXX Perhaps move this into a .bbappend that is only parsed with meta-networking (the layer with the recipe for ntp) is present.
do_install_prepend_pn-ntp() {
    # As recommeneded by https://developers.google.com/time/faq#how_do_i_use_google_public_ntp and
    # https://developers.google.com/time/guides
    sed -i -e  '/time.server.example.com/ s/^.*$/server time.google.com iburst prefer/' ${WORKDIR}/ntp.conf
}


# Allow per-device configuration from a USB flash drive. The webos-device-config service is run once when a USB flash drive is
# mounted upon WEBOS_DEVICE_CONFIG_MOUNTPOINT. It runs webos-device-config-invoke.sh, which, if it finds a
# WEBOS_DEVICE_CONFIG_MOUNTPOINT/DISTRO-device-config/WEBOS_DEVICE_CONFIG_VERSION/rc.local, runs it and then copies it to
# WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL, where upon subsequent boots, it will be run by /etc/rc.local . These settings can be
# overridden in conf/local.conf . Set WEBOS_DEVICE_CONFIG_MOUNTPOINT_pn-webos-initscripts to "" to disable the feature; set
# WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL_pn-webos-initscripts to "" to prevent the copying.
# XXX Eventually move into a .bbappend!!
WEBOS_DEVICE_CONFIG_MOUNTPOINT_pn-webos-initscripts = "/tmp/usb/sda/sda1"
WEBOS_DEVICE_CONFIG_VERSION_pn-webos-initscripts = "v1"
WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL_pn-webos-initscripts = "${webos_localstatedir}/webos-device-config/rc.local"

do_configure_prepend_pn-webos-initscripts() {
    if [ -n "${WEBOS_DEVICE_CONFIG_MOUNTPOINT}" ]; then
         # NB. The CMake variable WEBOS_TARGET_DISTRO is set to DISTRO by webos_cmake.bbclass .
        local distro_dir=${DISTRO}
        local systemd_system_scripts_dir=${base_libdir}/systemd/system/scripts
        # Handle older webos-initscripts layout and system scripts installation location:
        if [ ! -d ${S}/files/systemd/services/$distro_dir ]; then
            distro_dir=distro/${DISTRO}
            systemd_system_scripts_dir=${sysconfdir}/systemd/system/scripts
        fi

        local not_firstboot_sentinel_dir=$(dirname ${WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL})
        cat <<! > ${S}/files/systemd/services/$distro_dir/webos-device-config.service
# Copyright (c) 2019 LG Electronics, Inc.
#
# Invoke webos-device-config-invoke.sh, which handles the webOS per-device configuration rc.local on the USB flash drive
# automounted onto ${WEBOS_DEVICE_CONFIG_MOUNTPOINT} .

[Unit]
Description=webos - "%n"
# Launch after webos-ibd.target so that networking is up.
Requires=webos-ibd.target
After=webos-ibd.target
# XXX ConditionFirstBoot=true <- doesn't work!
# Temporary scheme until ConditionFirstBoot works. Doing it this way is marginally less secure (but only marginally, since local
# access is required to remove the sentinel file).
ConditionPathIsDirectory=!$not_firstboot_sentinel_dir

[Service]
Type=oneshot
ExecStart=$systemd_system_scripts_dir/webos-device-config-invoke.sh ${WEBOS_DEVICE_CONFIG_MOUNTPOINT}/${DISTRO}-device-config ${WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL}
# This has the fortunate side-effects of preventing a re-insertion from invoking it again and allowing rc-local.service to detect
# that is has been run:
RemainAfterExit=yes

# NB. .wants symlink "<sysconfdir>/systemd/system/<usb_mount_wants>/webos-device-config.service" installed by ${PN}.
!

        cat <<\! > ${S}/files/systemd/scripts/$distro_dir/webos-device-config-invoke.sh.in
#! /bin/sh
# Copyright (c) 2019 LG Electronics, Inc.
#
# webos-device-config-invoke.sh WEBOS-DEVICE-CONFIG-DIR-ON-USB [COPY-TO-PATH]

# Sanity check.
[ $# -eq 0 ] && exit 1

if [ -d $1 ]; then
    if [ -d $1/v1 ]; then
        rc_local=$1/v1/rc.local
        # This rc.local expects an argument just like /etc/rc.local does, but also recognizes "firstboot" as well as "start". If
        # it returns failure, don't copy it but return success to the unit file so that the sentinel is created.
        $rc_local firstboot || exit 0
        if [ $# -ge 2 ]; then
            copy_to_path=$2
            mkdir -p $(dirname $copy_to_path)
            cp -fp $rc_local $copy_to_path
            timestamp=$(date -u +%Y%m%d%H%M%S)
            echo >> $copy_to_path \
                "# Copied from $rc_local on $timestamp UTC (might not be accurate if the sync to network time has yet to occur)."
            unset timestamp
            unset copy_to_path
        fi
        unset rc_local

        exit 0
    # elif [ -d $1/v2 ]; then ...
    fi
fi

# Return failure if a script wasn't executed because, say, the USB flash drive that's present isn't a device config one.
exit 1
!
        # XXX Second -e only needed for older webos-initscripts layout.
        sed -i -e "/webos_configure_source_files(systemd_distro_in_scripts\$/ s@\$@ files/systemd/scripts/$distro_dir/webos-device-config-invoke.sh@" \
               -e "/set(systemd_units\$/ s@\$@ files/systemd/services/$distro_dir/webos-device-config.service@" \
            ${S}/CMakeLists.txt
    fi  # [ -n "${WEBOS_DEVICE_CONFIG_MOUNTPOINT}" ]


    # Remove AMENT_PREFIX_PATH from the default environment of webOS OSE. We add it and the others to the environment via
    # ros_setup.sh .
    sed -i -e '/ROS2 settings/ d' -e '/AMENT_PREFIX_PATH/ d' ${S}/files/systemd/environments/30-webos-global.conf.in
}
# ^^^^^ END do_configure_prepend_pn-webos-initscripts()

do_install_append_pn-webos-initscripts() {
    if [ -n "${WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL}" ]; then
        if [ ! -e ${D}${sysconfdir}/rc.local ]; then

            mkdir -p ${D}${sysconfdir}
            cat <<\! > ${D}${sysconfdir}/rc.local
#! /bin/sh
# Copyright (c) 2019 LG Electronics, Inc.
!
        fi
        cat <<\! >> ${D}${sysconfdir}/rc.local

# If webos-device-config.service is running, then it already ran ${WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL} before it was copied.
# ASSERT("$1" == "start")
if [ -x ${WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL} ] && ! systemctl -q is-active webos-device-config.service; then
    ${WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL} start
else
    true
fi
!
        chmod a+x ${D}${sysconfdir}/rc.local

        mkdir -p ${D}${sysconfdir}/systemd/system/rc-local.service.d
        cat <<! > ${D}${sysconfdir}/systemd/system/rc-local.service.d/30-after-webos-ibd.conf
# Copyright (c) 2019 LG Electronics, Inc.

[Unit]
# /etc/rc.local is meant to be run after networking is up; under webOS, this isn't the case until "webos-ibd.target" is
# reached.
Requires=webos-ibd.target
After=webos-ibd.target
!

        # Equivalent to adding WantedBy=$usb_mount.mount to [Install] section of webos-device-config.service
        local usb_mount_wants=$(echo ${WEBOS_DEVICE_CONFIG_MOUNTPOINT} | sed -e 's@/@-@g' -e 's@^-@@' -e 's/$/.mount.wants/')
        mkdir -p ${D}${sysconfdir}/systemd/system/$usb_mount_wants
        ln -snf ${systemd_system_unitdir}/webos-device-config.service ${D}${sysconfdir}/systemd/system/$usb_mount_wants/webos-device-config.service
    else
        true
    fi  # [ -n "${WEBOS_DEVICE_CONFIG_COPIED_RC_LOCAL}" ]
}
# ^^^^^ END do_install_append_pn-webos-initscripts()


# We need to revert changes from
#
# commit 49720e6d680d0041850c00ce6dc859d557825595
# Author: Alexander Kanavin <alex.kanavin@gmail.com>
# Date:   Thu Apr 11 18:00:37 2019 +0200
# Subject: python3: add a tr-tr locale for test_locale ptest
#
# because as described in:
# http://lists.openembedded.org/pipermail/openembedded-commits/2017-November/215520.html
# http://lists.openembedded.org/pipermail/openembedded-core/2018-October/156694.html
# it doesn't work when GLIBC_GENERATE_LOCALES are restricted like they are in webos builds:
# meta-webos/conf/distro/include/webos-toolchain.inc:GLIBC_GENERATE_LOCALES = "en_US.UTF-8"
RDEPENDS_python3-ptest_remove_libc-glibc = " \
    locale-base-tr-tr.iso-8859-9 \
"

RPI_KERNEL_DEVICETREE_append_rpi = " \
    bcm2710-rpi-3-b-plus.dtb \
"

# webos-rpi.inc _removes "kernel-modules" from MACHINE_EXTRA_RRECOMMENDS, and _remove happens last, so we can't add it back to
# MACHINE_EXTRA_RRECOMMENDS.
IMAGE_INSTALL_append_rpi = " kernel-modules"

# otherwise e.g. vboxguest needed by qemux86 webos-images isn't enabled and do_rootfs fails
PREFERRED_VERSION_linux-yocto = "4.18%"

# Undo blacklisting
PNBLACKLIST[libfreenect] ?= ""
PNBLACKLIST[freenect-camera] ?= ""
PNBLACKLIST[freenect-launch] ?= ""
PNBLACKLIST[map-server] ?= ""
PNBLACKLIST[wxwidgets] ?= ""
PNBLACKLIST[wxpython] ?= ""
PNBLACKLIST[freeglut] ?= ""
PNBLACKLIST[joint-state-publisher] ?= ""
PNBLACKLIST[realsense-camera] ?= ""
PNBLACKLIST[python-orocos-kdl] ?= ""
PNBLACKLIST[kdl-parser-py] ?= ""
PNBLACKLIST[kobuki-testsuite] ?= ""
PNBLACKLIST[sound-play] ?= ""
PNBLACKLIST[packagegroup-ros-world] ?= ""
PNBLACKLIST[sphinxbase] ?= ""
PNBLACKLIST[pocketsphinx] ?= ""
PNBLACKLIST[speech-tools] ?= ""
PNBLACKLIST[geographiclib] ?= ""
PNBLACKLIST[yaml-cpp] ?= ""
PNBLACKLIST[festival] ?= ""
PNBLACKLIST[python-wstool] ?= ""
PNBLACKLIST[rclcpp] ?= ""
PNBLACKLIST[pcl] ?= ""
PNBLACKLIST[ros2-demo-nodes-cpp] ?= ""
PNBLACKLIST[catkin] ?= ""
PNBLACKLIST[actionlib] ?= ""
PNBLACKLIST[actionlib-msgs] ?= ""
PNBLACKLIST[actionlib-tutorials] ?= ""
PNBLACKLIST[amcl] ?= ""
PNBLACKLIST[angles] ?= ""
PNBLACKLIST[ar-track-alvar] ?= ""
PNBLACKLIST[ar-track-alvar-msgs] ?= ""
PNBLACKLIST[audio-common-msgs] ?= ""
PNBLACKLIST[base-local-planner] ?= ""
PNBLACKLIST[bond] ?= ""
PNBLACKLIST[bondcpp] ?= ""
PNBLACKLIST[bondpy] ?= ""
PNBLACKLIST[camera-calibration] ?= ""
PNBLACKLIST[camera-calibration-parsers] ?= ""
PNBLACKLIST[camera-info-manager] ?= ""
PNBLACKLIST[camera-info-manager-py] ?= ""
PNBLACKLIST[can-msgs] ?= ""
PNBLACKLIST[capabilities] ?= ""
PNBLACKLIST[carrot-planner] ?= ""
PNBLACKLIST[chatter-msgs] ?= ""
PNBLACKLIST[chatter-receiver] ?= ""
PNBLACKLIST[chatter-sender] ?= ""
PNBLACKLIST[class-loader] ?= ""
PNBLACKLIST[clear-costmap-recovery] ?= ""
PNBLACKLIST[cmake-modules] ?= ""
PNBLACKLIST[collada-parser] ?= ""
PNBLACKLIST[collada-urdf] ?= ""
PNBLACKLIST[communication-tests] ?= ""
PNBLACKLIST[compressed-depth-image-transport] ?= ""
PNBLACKLIST[compressed-image-transport] ?= ""
PNBLACKLIST[concert-msgs] ?= ""
PNBLACKLIST[concert-service-msgs] ?= ""
PNBLACKLIST[concert-workflow-engine-msgs] ?= ""
PNBLACKLIST[controller-interface] ?= ""
PNBLACKLIST[controller-manager] ?= ""
PNBLACKLIST[controller-manager-msgs] ?= ""
PNBLACKLIST[controller-manager-tests] ?= ""
PNBLACKLIST[control-msgs] ?= ""
PNBLACKLIST[control-toolbox] ?= ""
PNBLACKLIST[convex-decomposition] ?= ""
PNBLACKLIST[costmap-2d] ?= ""
PNBLACKLIST[cpp-common] ?= ""
PNBLACKLIST[cv-bridge] ?= ""
PNBLACKLIST[cv-camera] ?= ""
PNBLACKLIST[cyclic-timer-tests] ?= ""
PNBLACKLIST[depth-image-proc] ?= ""
PNBLACKLIST[depthimage-to-laserscan] ?= ""
PNBLACKLIST[diagnostic-aggregator] ?= ""
PNBLACKLIST[diagnostic-analysis] ?= ""
PNBLACKLIST[diagnostic-common-diagnostics] ?= ""
PNBLACKLIST[diagnostic-msgs] ?= ""
PNBLACKLIST[diagnostic-updater] ?= ""
PNBLACKLIST[diff-drive-controller] ?= ""
PNBLACKLIST[dwa-local-planner] ?= ""
PNBLACKLIST[dynamic-reconfigure] ?= ""
PNBLACKLIST[ecl-build] ?= ""
PNBLACKLIST[ecl-command-line] ?= ""
PNBLACKLIST[ecl-concepts] ?= ""
PNBLACKLIST[ecl-config] ?= ""
PNBLACKLIST[ecl-console] ?= ""
PNBLACKLIST[ecl-containers] ?= ""
PNBLACKLIST[ecl-converters] ?= ""
PNBLACKLIST[ecl-converters-lite] ?= ""
PNBLACKLIST[ecl-core-apps] ?= ""
PNBLACKLIST[ecl-devices] ?= ""
PNBLACKLIST[ecl-eigen] ?= ""
PNBLACKLIST[ecl-errors] ?= ""
PNBLACKLIST[ecl-exceptions] ?= ""
PNBLACKLIST[ecl-filesystem] ?= ""
PNBLACKLIST[ecl-formatters] ?= ""
PNBLACKLIST[ecl-geometry] ?= ""
PNBLACKLIST[ecl-io] ?= ""
PNBLACKLIST[ecl-ipc] ?= ""
PNBLACKLIST[ecl-license] ?= ""
PNBLACKLIST[ecl-linear-algebra] ?= ""
PNBLACKLIST[ecl-math] ?= ""
PNBLACKLIST[ecl-mobile-robot] ?= ""
PNBLACKLIST[ecl-mpl] ?= ""
PNBLACKLIST[ecl-sigslots] ?= ""
PNBLACKLIST[ecl-sigslots-lite] ?= ""
PNBLACKLIST[ecl-statistics] ?= ""
PNBLACKLIST[ecl-streams] ?= ""
PNBLACKLIST[ecl-threads] ?= ""
PNBLACKLIST[ecl-time] ?= ""
PNBLACKLIST[ecl-time-lite] ?= ""
PNBLACKLIST[ecl-type-traits] ?= ""
PNBLACKLIST[ecl-utilities] ?= ""
PNBLACKLIST[effort-controllers] ?= ""
PNBLACKLIST[eigen-conversions] ?= ""
PNBLACKLIST[eigen-stl-containers] ?= ""
PNBLACKLIST[fake-localization] ?= ""
PNBLACKLIST[filters] ?= ""
PNBLACKLIST[force-torque-sensor-controller] ?= ""
PNBLACKLIST[forward-command-controller] ?= ""
PNBLACKLIST[frontier-exploration] ?= ""
PNBLACKLIST[gateway-msgs] ?= ""
PNBLACKLIST[gencpp] ?= ""
PNBLACKLIST[genlisp] ?= ""
PNBLACKLIST[genmsg] ?= ""
PNBLACKLIST[genpy] ?= ""
PNBLACKLIST[geodesy] ?= ""
PNBLACKLIST[geographic-info] ?= ""
PNBLACKLIST[geographic-msgs] ?= ""
PNBLACKLIST[geometric-shapes] ?= ""
PNBLACKLIST[geometry-msgs] ?= ""
PNBLACKLIST[global-planner] ?= ""
PNBLACKLIST[gmapping] ?= ""
PNBLACKLIST[gripper-action-controller] ?= ""
PNBLACKLIST[gscam] ?= ""
PNBLACKLIST[hardware-interface] ?= ""
PNBLACKLIST[hector-mapping] ?= ""
PNBLACKLIST[household-objects-database-msgs] ?= ""
PNBLACKLIST[image-geometry] ?= ""
PNBLACKLIST[image-proc] ?= ""
PNBLACKLIST[image-publisher] ?= ""
PNBLACKLIST[image-rotate] ?= ""
PNBLACKLIST[image-transport] ?= ""
PNBLACKLIST[image-view] ?= ""
PNBLACKLIST[imu-processors] ?= ""
PNBLACKLIST[imu-sensor-controller] ?= ""
PNBLACKLIST[imu-transformer] ?= ""
PNBLACKLIST[industrial-msgs] ?= ""
PNBLACKLIST[industrial-robot-client] ?= ""
PNBLACKLIST[industrial-robot-simulator] ?= ""
PNBLACKLIST[industrial-trajectory-filters] ?= ""
PNBLACKLIST[industrial-utils] ?= ""
PNBLACKLIST[ivcon] ?= ""
PNBLACKLIST[joint-limits-interface] ?= ""
PNBLACKLIST[joint-state-controller] ?= ""
PNBLACKLIST[joint-trajectory-controller] ?= ""
PNBLACKLIST[joy] ?= ""
PNBLACKLIST[kdl-conversions] ?= ""
PNBLACKLIST[kdl-parser] ?= ""
PNBLACKLIST[kobuki-auto-docking] ?= ""
PNBLACKLIST[kobuki-bumper2pc] ?= ""
PNBLACKLIST[kobuki-capabilities] ?= ""
PNBLACKLIST[kobuki-controller-tutorial] ?= ""
PNBLACKLIST[kobuki-description] ?= ""
PNBLACKLIST[kobuki-dock-drive] ?= ""
PNBLACKLIST[kobuki-driver] ?= ""
PNBLACKLIST[kobuki-keyop] ?= ""
PNBLACKLIST[kobuki-msgs] ?= ""
PNBLACKLIST[kobuki-node] ?= ""
PNBLACKLIST[kobuki-random-walker] ?= ""
PNBLACKLIST[kobuki-rapps] ?= ""
PNBLACKLIST[kobuki-safety-controller] ?= ""
PNBLACKLIST[laser-assembler] ?= ""
PNBLACKLIST[laser-filters] ?= ""
PNBLACKLIST[laser-geometry] ?= ""
PNBLACKLIST[libmavconn] ?= ""
PNBLACKLIST[manipulation-msgs] ?= ""
PNBLACKLIST[map-msgs] ?= ""
PNBLACKLIST[mavlink] ?= ""
PNBLACKLIST[mavros] ?= ""
PNBLACKLIST[mavros-extras] ?= ""
PNBLACKLIST[mavros-msgs] ?= ""
PNBLACKLIST[message-filters] ?= ""
PNBLACKLIST[message-generation] ?= ""
PNBLACKLIST[message-runtime] ?= ""
PNBLACKLIST[mk] ?= ""
PNBLACKLIST[move-base] ?= ""
PNBLACKLIST[move-base-msgs] ?= ""
PNBLACKLIST[moveit-core] ?= ""
PNBLACKLIST[moveit-kinematics] ?= ""
PNBLACKLIST[moveit-msgs] ?= ""
PNBLACKLIST[moveit-planners-ompl] ?= ""
PNBLACKLIST[moveit-ros-manipulation] ?= ""
PNBLACKLIST[moveit-ros-move-group] ?= ""
PNBLACKLIST[moveit-ros-perception] ?= ""
PNBLACKLIST[moveit-ros-planning] ?= ""
PNBLACKLIST[moveit-simple-controller-manager] ?= ""
PNBLACKLIST[move-slow-and-clear] ?= ""
PNBLACKLIST[nav-core] ?= ""
PNBLACKLIST[navfn] ?= ""
PNBLACKLIST[nav-msgs] ?= ""
PNBLACKLIST[nodelet] ?= ""
PNBLACKLIST[nodelet-topic-tools] ?= ""
PNBLACKLIST[nodelet-tutorial-math] ?= ""
PNBLACKLIST[object-recognition-msgs] ?= ""
PNBLACKLIST[octomap-msgs] ?= ""
PNBLACKLIST[octomap-ros] ?= ""
PNBLACKLIST[oneshot-timer-tests] ?= ""
PNBLACKLIST[openslam-gmapping] ?= ""
PNBLACKLIST[packagegroup-ros-comm.bb] ?= ""
PNBLACKLIST[pcl-conversions] ?= ""
PNBLACKLIST[pcl-msgs] ?= ""
PNBLACKLIST[pcl-ros] ?= ""
PNBLACKLIST[pluginlib] ?= ""
PNBLACKLIST[pluginlib-tutorials] ?= ""
PNBLACKLIST[polled-camera] ?= ""
PNBLACKLIST[position-controllers] ?= ""
PNBLACKLIST[random-numbers] ?= ""
PNBLACKLIST[razor-imu-9dof] ?= ""
PNBLACKLIST[realtime-tools] ?= ""
PNBLACKLIST[resource-retriever] ?= ""
PNBLACKLIST[rgbd-launch] ?= ""
PNBLACKLIST[robot-pose-ekf] ?= ""
PNBLACKLIST[robot-state-publisher] ?= ""
PNBLACKLIST[rocon-app-manager] ?= ""
PNBLACKLIST[rocon-app-manager-msgs] ?= ""
PNBLACKLIST[rocon-apps] ?= ""
PNBLACKLIST[rocon-app-utilities] ?= ""
PNBLACKLIST[rocon-bubble-icons] ?= ""
PNBLACKLIST[rocon-console] ?= ""
PNBLACKLIST[rocon-device-msgs] ?= ""
PNBLACKLIST[rocon-ebnf] ?= ""
PNBLACKLIST[rocon-gateway] ?= ""
PNBLACKLIST[rocon-gateway-tests] ?= ""
PNBLACKLIST[rocon-gateway-utils] ?= ""
PNBLACKLIST[rocon-hub] ?= ""
PNBLACKLIST[rocon-hub-client] ?= ""
PNBLACKLIST[rocon-icons] ?= ""
PNBLACKLIST[rocon-interaction-msgs] ?= ""
PNBLACKLIST[rocon-interactions] ?= ""
PNBLACKLIST[rocon-launch] ?= ""
PNBLACKLIST[rocon-master-info] ?= ""
PNBLACKLIST[rocon-python-comms] ?= ""
PNBLACKLIST[rocon-python-redis] ?= ""
PNBLACKLIST[rocon-python-utils] ?= ""
PNBLACKLIST[rocon-python-wifi] ?= ""
PNBLACKLIST[rocon-semantic-version] ?= ""
PNBLACKLIST[rocon-service-pair-msgs] ?= ""
PNBLACKLIST[rocon-std-msgs] ?= ""
PNBLACKLIST[rocon-test] ?= ""
PNBLACKLIST[rocon-tutorial-msgs] ?= ""
PNBLACKLIST[rocon-uri] ?= ""
PNBLACKLIST[rosapi] ?= ""
PNBLACKLIST[ros-arduino-firmware] ?= ""
PNBLACKLIST[ros-arduino-msgs] ?= ""
PNBLACKLIST[ros-arduino-python] ?= ""
PNBLACKLIST[rosauth] ?= ""
PNBLACKLIST[rosbag] ?= ""
PNBLACKLIST[rosbag-storage] ?= ""
PNBLACKLIST[rosbash] ?= ""
PNBLACKLIST[rosboost-cfg] ?= ""
PNBLACKLIST[rosbridge-library] ?= ""
PNBLACKLIST[rosbridge-server] ?= ""
PNBLACKLIST[rosbridge-suite] ?= ""
PNBLACKLIST[rosbuild] ?= ""
PNBLACKLIST[rosclean] ?= ""
PNBLACKLIST[rosconsole] ?= ""
PNBLACKLIST[rosconsole-bridge] ?= ""
PNBLACKLIST[roscpp] ?= ""
PNBLACKLIST[roscpp-serialization] ?= ""
PNBLACKLIST[roscpp-traits] ?= ""
PNBLACKLIST[roscpp-tutorials] ?= ""
PNBLACKLIST[roscreate] ?= ""
PNBLACKLIST[rosgraph] ?= ""
PNBLACKLIST[rosgraph-msgs] ?= ""
PNBLACKLIST[roslang] ?= ""
PNBLACKLIST[roslaunch] ?= ""
PNBLACKLIST[roslib] ?= ""
PNBLACKLIST[roslint] ?= ""
PNBLACKLIST[roslz4] ?= ""
PNBLACKLIST[rosmake] ?= ""
PNBLACKLIST[rosmaster] ?= ""
PNBLACKLIST[rosmsg] ?= ""
PNBLACKLIST[rosnode] ?= ""
PNBLACKLIST[rosout] ?= ""
PNBLACKLIST[rospack] ?= ""
PNBLACKLIST[rosparam] ?= ""
PNBLACKLIST[ros-pocketsphinx] ?= ""
PNBLACKLIST[rospy] ?= ""
PNBLACKLIST[rospy-tutorials] ?= ""
PNBLACKLIST[rosserial-arduino] ?= ""
PNBLACKLIST[rosserial-client] ?= ""
PNBLACKLIST[rosserial-embeddedlinux] ?= ""
PNBLACKLIST[rosserial-msgs] ?= ""
PNBLACKLIST[rosserial-python] ?= ""
PNBLACKLIST[rosserial-xbee] ?= ""
PNBLACKLIST[rosservice] ?= ""
PNBLACKLIST[rostest] ?= ""
PNBLACKLIST[rostime] ?= ""
PNBLACKLIST[rostopic] ?= ""
PNBLACKLIST[rosunit] ?= ""
PNBLACKLIST[roswtf] ?= ""
PNBLACKLIST[rotate-recovery] ?= ""
PNBLACKLIST[rt-tests-support] ?= ""
PNBLACKLIST[scheduler-msgs] ?= ""
PNBLACKLIST[sensor-msgs] ?= ""
PNBLACKLIST[shape-msgs] ?= ""
PNBLACKLIST[simple-message] ?= ""
PNBLACKLIST[smach] ?= ""
PNBLACKLIST[smach-msgs] ?= ""
PNBLACKLIST[smach-ros] ?= ""
PNBLACKLIST[smclib] ?= ""
PNBLACKLIST[socketcan-bridge] ?= ""
PNBLACKLIST[socketcan-interface] ?= ""
PNBLACKLIST[srdfdom] ?= ""
PNBLACKLIST[std-capabilities] ?= ""
PNBLACKLIST[std-msgs] ?= ""
PNBLACKLIST[std-srvs] ?= ""
PNBLACKLIST[stereo-image-proc] ?= ""
PNBLACKLIST[stereo-msgs] ?= ""
PNBLACKLIST[tf] ?= ""
PNBLACKLIST[tf2] ?= ""
PNBLACKLIST[tf2-eigen] ?= ""
PNBLACKLIST[tf2-geometry-msgs] ?= ""
PNBLACKLIST[tf2-kdl] ?= ""
PNBLACKLIST[tf2-msgs] ?= ""
PNBLACKLIST[tf2-py] ?= ""
PNBLACKLIST[tf2-ros] ?= ""
PNBLACKLIST[tf2-sensor-msgs] ?= ""
PNBLACKLIST[tf2-tools] ?= ""
PNBLACKLIST[tf-conversions] ?= ""
PNBLACKLIST[theora-image-transport] ?= ""
PNBLACKLIST[topic-tools] ?= ""
PNBLACKLIST[trajectory-msgs] ?= ""
PNBLACKLIST[transmission-interface] ?= ""
PNBLACKLIST[unique-id] ?= ""
PNBLACKLIST[urdf] ?= ""
PNBLACKLIST[urdfdom-py] ?= ""
PNBLACKLIST[urdf-parser-plugin] ?= ""
PNBLACKLIST[urdf-tutorial] ?= ""
PNBLACKLIST[uuid-msgs] ?= ""
PNBLACKLIST[velocity-controllers] ?= ""
PNBLACKLIST[velodyne-driver] ?= ""
PNBLACKLIST[velodyne-msgs] ?= ""
PNBLACKLIST[velodyne-pointcloud] ?= ""
PNBLACKLIST[visualization-msgs] ?= ""
PNBLACKLIST[voxel-grid] ?= ""
PNBLACKLIST[xacro] ?= ""
PNBLACKLIST[xmlrpcpp] ?= ""
PNBLACKLIST[xv-11-laser-driver] ?= ""
PNBLACKLIST[yocs-ar-marker-tracking] ?= ""
PNBLACKLIST[yocs-ar-pair-approach] ?= ""
PNBLACKLIST[yocs-ar-pair-tracking] ?= ""
PNBLACKLIST[yocs-cmd-vel-mux] ?= ""
PNBLACKLIST[yocs-controllers] ?= ""
PNBLACKLIST[yocs-diff-drive-pose-controller] ?= ""
PNBLACKLIST[yocs-joyop] ?= ""
PNBLACKLIST[yocs-keyop] ?= ""
PNBLACKLIST[yocs-localization-manager] ?= ""
PNBLACKLIST[yocs-math-toolkit] ?= ""
PNBLACKLIST[yocs-msgs] ?= ""
PNBLACKLIST[yocs-navigator] ?= ""
PNBLACKLIST[yocs-rapps] ?= ""
PNBLACKLIST[yocs-safety-controller] ?= ""
PNBLACKLIST[yocs-velocity-smoother] ?= ""
PNBLACKLIST[yocs-virtual-sensor] ?= ""
PNBLACKLIST[yocs-waypoint-provider] ?= ""
PNBLACKLIST[yocs-waypoints-navi] ?= ""
PNBLACKLIST[zeroconf-avahi] ?= ""
PNBLACKLIST[zeroconf-avahi-demos] ?= ""
PNBLACKLIST[zeroconf-msgs] ?= ""
PNBLACKLIST[ros-sdk-test] ?= ""
PNBLACKLIST[core-image-ros-roscore] ?= ""
PNBLACKLIST[core-image-ros-world] ?= ""
PNBLACKLIST[packagegroup-ros-kobuki] ?= ""
PNBLACKLIST[packagegroup-ros-comm] ?= ""
PNBLACKLIST[packagegroup-ros-industrial-core] ?= ""

PNBLACKLIST[graphviz] ?= ""
PNBLACKLIST[librsvg] ?= ""
PNBLACKLIST[libsdl] ?= ""
PNBLACKLIST[libsdl-image] ?= ""
