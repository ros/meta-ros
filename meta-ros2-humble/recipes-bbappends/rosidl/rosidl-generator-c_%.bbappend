# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

# it's already in ROS_TEST_DEPENDS, but do_configure fails without
# it even when testing isn't enabled
DEPENDS += "rosidl-runtime-c"

# exported in rosidl_generator_c/cmake/ament_cmake_export_dependencies-extras.cmake
DEPENDS += "rosidl-cmake"

# # ERROR: do_package: Files/directories were installed but not shipped in any package
# #
# # NOTE: Can't use ${PN} in the additions below because of the "-" and "_" conflict (recipes and package names differ in this regard)
# #
# PNQAFIX = "rosidl_generator_c"
# FILES:${PN} += " \
#     ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
#     ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}-3.1.3-py3.9.egg-info \
# "

INSANE_SKIP:${PN} += " installed-vs-shipped"
