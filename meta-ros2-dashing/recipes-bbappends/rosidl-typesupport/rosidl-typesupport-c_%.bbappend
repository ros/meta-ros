# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'rosidl-typesupport-connext-c', '', d)}"
ROS_BUILD_DEPENDS_remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'rosidl-typesupport-opensplice-c', '', d)}"
