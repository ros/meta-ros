# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

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
    service-msgs \
"

# package.xml declares "BSD" but neither the package nor its upstream
# repository has any license text. BSD-3-Clause is assumed as the usual
# meaning of "BSD" in ROS packages.
LICENSE = "BSD-3-Clause"
