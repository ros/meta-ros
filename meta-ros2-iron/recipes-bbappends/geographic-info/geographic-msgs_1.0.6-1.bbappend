# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# QA Issue "package geographic-msgs requires libservice_msgs" [file-rdeps]
ROS_EXEC_DEPENDS += " \
    service-msgs \
"
