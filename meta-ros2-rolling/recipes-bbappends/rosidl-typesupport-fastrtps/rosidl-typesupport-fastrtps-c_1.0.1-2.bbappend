# Copyright (c) 2019 LG Electronics, Inc.

# Without the target rosidl-typesupport-fastrtps-cpp, ament finds the native packages and then fails to link
# (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    fastcdr \
    fastrtps \
    rosidl-typesupport-fastrtps-cpp \
"
