# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022-2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Fix-build-with-gcc-11.patch"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"

inherit pkgconfig
