# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2025 Wind River Systems, Inc

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-adapter \
"

# QA Issue: File /opt/ros/humble/share/rosbag2_transport/cmake/export_rosbag2_transportExport.cmake in package rosbag2-transport-dev contains reference to TMP
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/share/rosbag2_transport/cmake/export_rosbag2_transportExport.cmake
}
