# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILD_TYPE = "ament_cmake"

inherit ros_${ROS_BUILD_TYPE}

ROS_BUILDTOOL_DEPENDS += "\
    rosidl-default-runtime-native \
"
