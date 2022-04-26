# Copyright (c) 2022 Acceleration Robotics, S.L.

# ERROR: do_package: QA Issue: rosidl-adapter: Files/directories were installed but not shipped in any package
#
# NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
#
FILES:${PN}:prepend = " \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_typesupport_introspection_c \
    ${WORKDIR}/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_typesupport_introspection_c-3.1.3-py3.9.egg-info \
"
