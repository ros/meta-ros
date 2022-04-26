# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

ROS_EXPORT_DEPENDS += " \
    rosidl-generator-c \
    rosidl-typesupport-c \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Revert-Install-generated-Python-interfaces-in-a-Pyth.patch"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
PNQAFIX = "rosidl_generator_py"

FILES:${PN}:prepend = " \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/${PNQAFIX} \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/${PNQAFIX}-0.14.2-py3.9.egg-info \
"
