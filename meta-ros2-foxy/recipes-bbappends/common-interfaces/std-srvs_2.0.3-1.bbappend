# Copyright (c) 2020 LG Electronics, Inc.

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    rosidl-default-runtime \
"

ROS_BUILD_DEPENDS += " \
    builtin-interfaces \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
"
ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
    rosidl-adapter-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    python3-numpy-native \
    python3-lark-parser-native \
"
ROS_EXEC_DEPENDS += " \
    builtin-interfaces \
"
