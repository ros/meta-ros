# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: multisense-lib-4.0.3-1-r0 do_package_qa: QA Issue:
# package multisense-lib contains bad RPATH multisense-lib/4.0.3-1-r0/devel/lib in file multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/multisense_lib/DeviceInfoUtility
# package multisense-lib contains bad RPATH multisense-lib/4.0.3-1-r0/devel/lib in file multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/multisense_lib/ImageCalUtility
# package multisense-lib contains bad RPATH multisense-lib/4.0.3-1-r0/devel/lib in file multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/multisense_lib/LidarCalUtility
# package multisense-lib contains bad RPATH multisense-lib/4.0.3-1-r0/devel/lib in file multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/multisense_lib/ImuTestUtility
# package multisense-lib contains bad RPATH multisense-lib/4.0.3-1-r0/devel/lib in file multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/multisense_lib/ChangeIpUtility
# package multisense-lib contains bad RPATH multisense-lib/4.0.3-1-r0/devel/lib in file multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/multisense_lib/FlashUtility
# package multisense-lib contains bad RPATH multisense-lib/4.0.3-1-r0/devel/lib in file multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/multisense_lib/ImuConfigUtility
# package multisense-lib contains bad RPATH multisense-lib/4.0.3-1-r0/devel/lib in file multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/multisense_lib/SaveImageUtility [rpaths]
DEPENDS_append_class-target = " chrpath-replacement-native"
do_install_append() {
    # all except /opt/ros/melodic/lib/multisense_lib/MultiSenseUpdater
    chrpath --delete ${D}${ros_libdir}/${ROS_BPN}/*Utility
}

# Default FILES have ${ros_libdir}/lib*.so, but don't cover /opt/ros/melodic/lib/libMultiSense.so.3.8
# ERROR: multisense-lib-4.0.3-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: multisense-lib path '/work/core2-64-oe-linux/multisense-lib/4.0.3-1-r0/packages-split/multisense-lib/opt/ros/melodic/lib/libMultiSense.so' [dev-so]
inherit ros_insane_dev_so

# ERROR: multisense-lib-4.0.3-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/multisense_lib/MultiSenseUpdater contained in package multisense-lib requires /bin/bash, but no providers found in RDEPENDS_multisense-lib? [file-rdeps]
ROS_EXEC_DEPENDS += " \
    bash \
"

# This is needed only for webOS OSE, which uses busybox to provide
# bash by default, but with newer OSE this should respect
# WEBOS_PREFERRED_PROVIDER_FOR_BASH and it's not in meta-ros-webos, because
# then meta-ros-webos would need to include this .bbappend just when
# meta-ros1-melodic layer is included
VIRTUAL-RUNTIME_bash ?= "bash"
RDEPENDS_${PN}_append_class-target_webos = " ${VIRTUAL-RUNTIME_bash}"
RDEPENDS_${PN}_remove_class-target_webos = "${@oe.utils.conditional('WEBOS_PREFERRED_PROVIDER_FOR_BASH', 'busybox', 'bash', '', d)}"
