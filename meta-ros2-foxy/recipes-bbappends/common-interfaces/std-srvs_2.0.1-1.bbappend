# Copyright (c) 2020 LG Electronics, Inc.

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    rosidl-default-runtime \
    rosidl-adapter-native \
"

ROS_BUILD_DEPENDS += " \
    python3-lark-parser-native \
    python3-numpy-native \
    rosidl-parser-native \
    rpyutils-native \
"
