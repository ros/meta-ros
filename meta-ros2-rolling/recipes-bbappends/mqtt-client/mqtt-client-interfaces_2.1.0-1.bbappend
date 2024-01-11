# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
    rosidl-default-runtime-native \
"

# QA Issue "package mqtt-client-interfaces requires libservice_msgs" [file-rdeps]
ROS_EXEC_DEPENDS += " \
    service-msgs \
"
