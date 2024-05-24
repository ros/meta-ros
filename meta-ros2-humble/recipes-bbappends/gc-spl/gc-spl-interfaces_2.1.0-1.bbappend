# Copyright (c) 2024, Wind River Systems, Inc.

SRC_URI = "git://github.com/ros2-gbp/game_controller_spl-release;${ROS_BRANCH};protocol=https"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

ROS_BUILD_DEPENDS += " \
    rosidl-default-runtime \
"
