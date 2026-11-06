# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
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

# package.xml declares "BSD" but neither the package nor its upstream
# repository has any license text. BSD-3-Clause is assumed as the usual
# meaning of "BSD" in ROS packages.
LICENSE = "BSD-3-Clause"
