# Copyright (c) 2020 LG Electronics, Inc.

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += "\
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

# package.xml declares "BSD" but the only license text in the upstream
# repository (ros_canopen) is a root LICENSE with LGPL-3.0, so both are
# listed.
LICENSE = "BSD-3-Clause & LGPL-3.0-only"
