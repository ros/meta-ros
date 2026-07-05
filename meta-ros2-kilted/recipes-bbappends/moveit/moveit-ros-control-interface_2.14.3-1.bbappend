# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://remove-boost-system.patch \
            file://add-bullet-dependency.patch"

# ERROR: moveit-ros-control-interface-2.3.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package moveit-ros-control-interface contains symlink .so '/usr/lib/libmoveit_ros_control_interface_trajectory_plugin.so'
# non -dev/-dbg/nativesdk- package moveit-ros-control-interface contains symlink .so '/usr/lib/libmoveit_ros_control_interface_plugin.so'
# non -dev/-dbg/nativesdk- package moveit-ros-control-interface contains symlink .so '/usr/lib/libmoveit_ros_control_interface_gripper_plugin.so' [dev-so]
inherit ros_insane_dev_so
