# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-ros-native \
    python3-numpy-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://do-not-set-compiler-options.patch"

# QA Issue: File /opt/ros/rolling/share/hardware_interface/cmake/export_hardware_interfaceExport.cmake in package hardware-interface-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/hardware_interface/cmake/export_hardware_interfaceExport.cmake
}
