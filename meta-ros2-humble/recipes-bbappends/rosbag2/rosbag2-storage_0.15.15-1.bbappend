# Copyright (c) 2025 Wind River Systems, Inc

# QA Issue: File /opt/ros/humble/share/rosbag2_storage/cmake/export_rosbag2_storageExport.cmake in package rosbag2-storage-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/rosbag2_storage/cmake/export_rosbag2_storageExport.cmake
}
