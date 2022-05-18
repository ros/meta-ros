# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

# Without the target rosidl-typesupport-fastrtps-cpp, ament finds the native packages and then fails to link
# (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    fastcdr \
    rosidl-typesupport-fastrtps-cpp \
"

# Deal with CMake Error while building recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-CMake-Error-while-building-recipe.patch \
"

# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
PNQAFIX = "rosidl_typesupport_fastrtps_c"
do_install:append() {
    mkdir -p ${D}${libdir}/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}* ${D}${libdir}/python3.9/site-packages/
    rm -r ${D}/home
}

# QA Issue: rosidl-typesupport-fastrtps-c: Files/directories were installed but not shipped in any package:
#   /usr/lib/librosidl_typesupport_fastrtps_c.so
FILES:${PN} += "${libdir}/lib*${SOLIBSDEV}"