# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    tl-expected \
"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-runtime-native \
"

# tl-expected does not have a runtime package
ROS_EXEC_DEPENDS:remove = "tl-expected"

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}
