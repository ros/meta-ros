# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# QA Issue: File /opt/ros/rolling/share/pcl_ros/cmake/export_pcl_rosExport.cmake in package pcl-ros-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_datadir}/pcl_ros/cmake/export_pcl_rosExport.cmake
}
