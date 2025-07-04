# Copyright (c) 2022 Wind River Systems, Inc.

# ModuleNotFoundError: No module named 'jinja2'
ROS_BUILDTOOL_DEPENDS += "python3-jinja2-native"

FILES:${PN} += "${datadir}/schemas/*"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
