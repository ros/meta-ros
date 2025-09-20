# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-tinyxml-by-name.patch \
            file://remove-buildpath.patch"

inherit pkgconfig

ROS_BUILD_DEPENDS += " \
    tinyxml2-vendor \
    libtinyxml2 \
"

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros-native \
    python3-numpy-native \
"

# QA Issue: File /opt/ros/rolling/share/hardware_interface/cmake/export_hardware_interfaceExport.cmake in package hardware-interface-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/hardware_interface/cmake/export_hardware_interfaceExport.cmake
}
