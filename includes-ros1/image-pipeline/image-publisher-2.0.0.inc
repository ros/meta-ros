# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS += "yaml-cpp-vendor"

FILESEXTRAPATHS_prepend := "${THISDIR}/image-publisher:"
SRC_URI += "file://0001-Add-yaml-cpp-vendor-as-dependency.patch"
