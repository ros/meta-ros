# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
    rosidl-adapter-native \
    python3-numpy-native \
    python3-lark-parser-native \
"

# inherit python3native

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    python3 \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    rosidl-runtime-c \
    rosidl-runtime-cpp \
    rosidl-typesupport-introspection-c \
    rosidl-typesupport-introspection-cpp \
    rmw \
"

DEPENDS += " \
    python3-numpy-native \
    rpyutils-native \
"
