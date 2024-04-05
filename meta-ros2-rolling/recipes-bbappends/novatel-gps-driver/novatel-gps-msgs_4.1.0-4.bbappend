# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-runtime-native \
"

# QA Issue "package novatel-gps-msgs requires libservice_msgs" [file-rdeps]
ROS_EXEC_DEPENDS += " \
    service-msgs \
"
