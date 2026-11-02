# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-bullet-dependency.patch"

ROS_BUILD_DEPENDS += " eigen3-cmake-module"

# ERROR: moveit-ros-move-group-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-move-group path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-move-group/2.1.0-1-r0/packages-split/moveit-ros-move-group/usr/lib/libmoveit_move_group_default_capabilities.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-move-group path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-move-group/2.1.0-1-r0/packages-split/moveit-ros-move-group/usr/lib/libmoveit_move_group_capabilities_base.so'
# [dev-so]
inherit ros_insane_dev_so
