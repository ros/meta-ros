# Copyright (c) 2021 LG Electronics, Inc.

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    rosidl-default-runtime \
    rosidl-adapter-native \
    ament-cmake-ros-native \
    python3-numpy-native \
    rosidl-generator-c-native \
    rosidl-generator-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
    rosidl-typesupport-cpp-native \
    rosidl-generator-py-native \
"

# backport equivalent of following changes:
# dashing: https://github.com/ros/rosdistro/commit/e27c2fdadc560e6ecf653d73d01d3cff10bda49e
# foxy: https://github.com/ros/rosdistro/commit/ef8ab3a3d8ca3b9de81807050f22ec4a300fb6f2
SRC_URI = "git://github.com/ros2-gbp/fmi_adapter-release;${ROS_BRANCH};protocol=https"
