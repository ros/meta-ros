# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

# Fix for Honister release only:
inherit distutils3-base

ROS_EXPORT_DEPENDS += " \
    rosidl-generator-c \
    rosidl-typesupport-c \
"

# integrates previous and new patches
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-CMake-Error-while-building-recipe.patch \
"
# previous patch
# file://0001-Revert-Install-generated-Python-interfaces-in-a-Pyth.patch
