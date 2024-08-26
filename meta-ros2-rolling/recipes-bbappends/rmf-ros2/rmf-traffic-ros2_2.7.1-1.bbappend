# Copyright (c) 2022-2023 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "eigen3-cmake-module"

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"

inherit pkgconfig
