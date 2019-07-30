# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
"

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    fastcdr \
    fastrtps \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
"
