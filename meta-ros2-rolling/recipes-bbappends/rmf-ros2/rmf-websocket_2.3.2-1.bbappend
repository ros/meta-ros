# Copyright (c) 2022 Wind River Systems, Inc.

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"

# websocketpp does not provide runtime components
ROS_EXEC_DEPENDS:remove = "websocketpp"
