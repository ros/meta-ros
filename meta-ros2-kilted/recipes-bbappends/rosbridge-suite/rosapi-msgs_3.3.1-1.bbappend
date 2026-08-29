# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
    service-msgs \
"
