# Copyright (c) 2019-2021 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS:append = " \
    ament-cmake-native \
"

ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'rosidl-typesupport-connext-cpp', '', d)}"
ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'rosidl-typesupport-opensplice-cpp', '', d)}"

DEPENDS += "rosidl-cmake"
