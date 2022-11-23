# Copyright (c) 2021 LG Electronics, Inc.
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

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Fix-build-with-gpsd-3.21.patch \
    file://0002-Fix-build-with-gpsd-3.23.1.patch \
    file://0003-Be-a-bit-more-strict-when-checking-the-symbols-defin.patch \
"

inherit pkgconfig
