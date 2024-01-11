# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.
 
ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

# moveit-ros-planning is in ROS_TEST_DEPENDS but CMake checks for that even
# when building with tests disabled
DEPENDS += "moveit-ros-planning"

# ERROR: moveit-kinematics-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-kinematics path '/work/raspberrypi4-webos-linux-gnueabi/moveit-kinematics/2.1.0-1-r0/packages-split/moveit-kinematics/usr/lib/libmoveit_cached_ik_kinematics_plugin.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-kinematics path '/work/raspberrypi4-webos-linux-gnueabi/moveit-kinematics/2.1.0-1-r0/packages-split/moveit-kinematics/usr/lib/libmoveit_lma_kinematics_plugin.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-kinematics path '/work/raspberrypi4-webos-linux-gnueabi/moveit-kinematics/2.1.0-1-r0/packages-split/moveit-kinematics/usr/lib/libmoveit_srv_kinematics_plugin.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-kinematics path '/work/raspberrypi4-webos-linux-gnueabi/moveit-kinematics/2.1.0-1-r0/packages-split/moveit-kinematics/usr/lib/libmoveit_cached_ik_kinematics_base.so'
# [dev-so]
inherit ros_insane_dev_so

# ERROR: moveit-kinematics-2.1.0-1-r0 do_package_qa: QA Issue: /usr/lib/moveit_kinematics/auto_create_ikfast_moveit_plugin.sh contained in package moveit-kinematics requires /bin/bash, but no providers found in RDEPENDS:moveit-kinematics? [file-rdeps]
RDEPENDS:${PN} += "bash"

# This is needed only for webOS OSE and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros2-foxy layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS:${PN}:append:class-target:webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS:${PN}:remove:class-target:webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
