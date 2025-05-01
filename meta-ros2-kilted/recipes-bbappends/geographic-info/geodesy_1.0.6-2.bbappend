# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-ros-native \
    python3-numpy-native \
    rosidl-adapter-native \
    rosidl-generator-c-native \
    rosidl-generator-cpp-native \
    rosidl-generator-py-native \
    rosidl-typesupport-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
"

# ROS2 is python3-only and python2 is blacklisted here
ROS_BUILD_DEPENDS:remove = "python-catkin-pkg"
ROS_BUILD_DEPENDS:append = " python3-catkin-pkg"

ROS_BUILD_DEPENDS += " \
    service-msgs \
"
