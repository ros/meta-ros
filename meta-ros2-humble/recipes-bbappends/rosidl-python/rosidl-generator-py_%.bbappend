# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

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

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
do_install:append:class-target() {
    mkdir -p ${D}/usr/lib/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}/usr/lib/python3.9/site-packages/${ROS_BPN}* ${D}/usr/lib/python3.9/site-packages/
    rm -r ${D}/home
}