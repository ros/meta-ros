# Copyright (c) 2020-2021 LG Electronics, Inc.

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    rosidl-default-runtime \
"

ROS_BUILD_DEPENDS += " \
    fastcdr \
    fastrtps \
"

# usr/share/builtin_interfaces/cmake/ament_cmake_export_dependencies-extras.cmake contains:
#
#     set(_exported_dependencies "rosidl_default_runtime")

ROS_EXPORT_DEPENDS += "rosidl-default-runtime"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
    rosidl-adapter-native \
    python3-numpy-native \
    python3-lark-parser-native \
"

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
"

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    rosidl-generator-cpp-native \
    rosidl-typesupport-introspection-cpp-native \
    rosidl-typesupport-cpp-native \
    rosidl-generator-py-native \
    fastrtps-cmake-module \
    python-cmake-module \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-generator-cpp \
"
