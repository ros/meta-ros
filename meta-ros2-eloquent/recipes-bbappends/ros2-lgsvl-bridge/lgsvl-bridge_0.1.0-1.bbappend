# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "ament-cmake-ros-native \
    boost \
    rcutils \
    rcl \
    rosidl-generator-c \
    rosidl-adapter \
"

# https://github.com/lgsvl/ros2-lgsvl-bridge-release/issues/1
ROS_BRANCH_append = "-before-rebase"
