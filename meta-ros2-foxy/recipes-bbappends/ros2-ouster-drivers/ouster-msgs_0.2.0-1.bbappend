# Copyright (c) 2020 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-gmock \
    ament-cmake-gtest \
    ament-cmake-pytest \
    ament-cmake-ros \
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

ROS_BUILD_DEPENDS += " \
    python3-lark-parser-native \
    rosidl-parser-native \
    rpyutils-native \
"
