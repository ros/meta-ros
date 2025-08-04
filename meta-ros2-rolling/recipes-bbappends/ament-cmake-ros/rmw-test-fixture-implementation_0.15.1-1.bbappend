# Copyright (c) 2025 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "\
    rosidl-generator-cpp-native \
"

# Remove rmw-zenoh-cpp if zenoh-layer is not present
ROS_EXEC_DEPENDS:remove = "${@bb.utils.contains('BBFILE_COLLECTIONS', 'zenoh-layer', '', 'rmw-zenoh-cpp', d)}"
