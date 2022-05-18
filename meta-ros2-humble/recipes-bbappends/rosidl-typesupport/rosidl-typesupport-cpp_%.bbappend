# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'rosidl-typesupport-connext-cpp', '', d)}"
ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'rosidl-typesupport-opensplice-cpp', '', d)}"

DEPENDS += "rosidl-cmake"

# Deal with CMake Error while building recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-CMake-Error-while-building-recipe.patch \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
PNQAFIX = "rosidl_typesupport_cpp"
do_install:append() {
    mkdir -p ${D}${libdir}/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}* ${D}${libdir}/python3.9/site-packages/
    rm -r ${D}/home
}

# QA Issue: rosidl-typesupport-cpp: Files/directories were installed but not shipped in any package:
#   /usr/lib/librosidl_typesupport_cpp.so
FILES:${PN} += "${libdir}/lib*${SOLIBSDEV}"