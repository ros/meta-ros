# Copyright (c) 2022 Wind River Systems, Inc.

DEPENDS += "python3-pybind11-json"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
