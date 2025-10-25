# Copyright (c) 2020-2021 LG Electronics, Inc.

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    rosidl-default-runtime \
    service-msgs \
"

ROS_EXEC_DEPENDS += " \
    builtin-interfaces \
"
