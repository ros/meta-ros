# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
    generate-parameter-library-py-native \
"

ROS_EXEC_DEPENDS:remove = "${ROS_UNRESOLVED_DEP-range-v3}"
