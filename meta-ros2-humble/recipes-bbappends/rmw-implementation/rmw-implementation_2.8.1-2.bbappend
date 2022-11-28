# Copyright (c) 2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'rmw-connext-cpp', '', d)}"

ROS_BUILDTOOL_DEPENDS:append = " \
    rosidl-adapter-native \
    rosidl-generator-cpp-native \
"

ROS_EXEC_DEPENDS:append = " \
    rmw-fastrtps-cpp \
    rmw-cyclonedds-cpp \
"
