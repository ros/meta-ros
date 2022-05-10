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
PNQAFIX = "rosidl_typesupport_introspection_cpp"
FILES:${PN} = " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}-3.1.3-py3.9.egg-info \
"

# QA Issue: rosidl-typesupport-introspection-cpp: Files/directories were installed but not shipped in any package:
#   /usr/lib/librosidl_typesupport_introspection_cpp.so
FILES:${PN} += "${libdir}/lib*${SOLIBSDEV}"