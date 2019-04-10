# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/ros1-rosbag-storage-vendor:"

SRC_URI += " \
    file://0001-Pass-toolchain.cmake-to-external-project.patch \
"
