# Copyright (c) 2022 Acceleration Robotics, S.L.

# Deal with CMake Error while building recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-CMake-Error-while-building-recipe.patch \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
do_install:append:class-target() {
    mkdir -p ${D}/usr/lib/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}/usr/lib/python3.9/site-packages/${ROS_BPN}* ${D}/usr/lib/python3.9/site-packages/
    rm -r ${D}/home
}

# QA Issue: rosidl-typesupport-introspection-cpp: Files/directories were installed but not shipped in any package:
#   /usr/lib/librosidl_typesupport_introspection_cpp.so
FILES:${PN} += "${libdir}/lib*${SOLIBSDEV}"