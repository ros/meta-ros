# Copyright (c) 2022 Acceleration Robotics, S.L.

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
PNQAFIX = "rosidl_typesupport_introspection_cpp"

FILES:${PN}:prepend = " \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/${PNQAFIX} \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/${PNQAFIX}-3.1.3-py3.9.egg-info \
"
