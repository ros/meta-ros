# Copyright (c) 2022 Acceleration Robotics, S.L.

# Deal with CMake Error while building recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-CMake-error-while-building-recipe.patch \
"

# ERROR: do_package: QA Issue: rosidl-adapter: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
FILES:${PN} = " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/rosidl_typesupport_introspection_c \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/rosidl_typesupport_introspection_c-3.1.3-py3.9.egg-info \
"

# QA Issue: rosidl-typesupport-introspection-c: Files/directories were installed but not shipped in any package:
#   /usr/lib/librosidl_typesupport_introspection_c.so
FILES:${PN} += "${libdir}/lib*${SOLIBSDEV}"