# Copyright (c) 2025 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "\
    rosidl-generator-cpp-native \
"

ROS_EXEC_DEPENDS:remove = "rmw-zenoh-cpp"
ROS_EXEC_DEPENDS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'clang-layer', 'rmw-zenoh-cpp', '', d)}"
