# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-bullet-dependency.patch"

ROS_BUILD_DEPEND += "rosidl-adapter"

# ERROR: moveit-simple-controller-manager-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-simple-controller-manager path '/work/raspberrypi4-webos-linux-gnueabi/moveit-simple-controller-manager/2.1.0-1-r0/packages-split/moveit-simple-controller-manager/usr/lib/libmoveit_simple_controller_manager.so' [dev-so]
inherit ros_insane_dev_so
