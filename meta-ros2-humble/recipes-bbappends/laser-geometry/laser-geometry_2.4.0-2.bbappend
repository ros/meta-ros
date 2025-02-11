# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

ROS_BUILD_DEPENDS += " \
    rosidl-adapter \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://switch-to-target_link_libraries.patch \
            file://0001-Remove-unneeded-Eigen3_INCLUDE_DIRS.patch"

# QA Issue: File /opt/ros/humble/share/laser_geometry/cmake/laser_geometryExport.cmake in package joy-dev contains reference to TMPDIR [buildpaths]
#do_install:append() {
#    sed -i -e "s#${RECIPE_SYSROOT}/usr/include/eigen3##g" ${D}${ros_prefix}/share/laser_geometry/cmake/laser_geometryExport.cmake
#}
