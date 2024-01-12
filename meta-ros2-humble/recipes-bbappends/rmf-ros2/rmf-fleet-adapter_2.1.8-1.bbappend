# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-FleetUpdateHandle-use-uint64_t-instead-of-std-size_t.patch \
"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
