# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "eigen3-cmake-module"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
