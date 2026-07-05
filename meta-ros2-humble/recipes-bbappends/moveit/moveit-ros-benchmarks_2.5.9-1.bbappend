# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch"

# ERROR: moveit-ros-benchmarks-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-benchmarks path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-benchmarks/2.1.0-1-r0/packages-split/moveit-ros-benchmarks/usr/lib/libmoveit_ros_benchmarks.so' [dev-so]
inherit ros_insane_dev_so

# error: #error This header is deprecated and will be removed. (You can define BOOST_TIMER_ENABLE_DEPRECATED to suppress this error.)
CXXFLAGS += " -DBOOST_TIMER_ENABLE_DEPRECATED"
