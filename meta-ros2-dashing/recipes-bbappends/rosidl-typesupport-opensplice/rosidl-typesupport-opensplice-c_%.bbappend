# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rosidl-typesupport-opensplice-c] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'opensplice: depends on libopensplice69-native which is not available', '', d)}"
