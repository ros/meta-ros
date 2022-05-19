# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

# it's already in ROS_TEST_DEPENDS, but do_configure fails without
# it even when testing isn't enabled
DEPENDS += "rosidl-runtime-c"

# exported in rosidl_generator_c/cmake/ament_cmake_export_dependencies-extras.cmake
DEPENDS += "rosidl-cmake"

# | CMake Error at /home/xilinx/xilinx-k26-som-2022.1/build/tmp/work/cortexa72-cortexa53-xilinx-linux/builtin-interfaces/1.2.0-2-r0/recipe-sysroot/usr/share/rosidl_generator_c/cmake/rosidl_generator_c_generate_interfaces.cmake:69 (message):
# |   Target dependency
# |   '/home/xilinx/xilinx-k26-som-2022.1/build/tmp/work/cortexa72-cortexa53-xilinx-linux/builtin-interfaces/1.2.0-2-r0/recipe-sysroot/usr/share/rosidl_generator_c/cmake/../../../../home/xilinx/xilinx-k26-som-2022.1/build/tmp/work/cortexa72-cortexa53-xilinx-linux/builtin-interfaces/1.2.0-2-r0/recipe-sysroot-native/usr/lib/python3.9/site-packages/rosidl_generator_c/__init__.py'
# |   does not exist
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-honister-dependency-error.patch \
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

# # INSANE_SKIP:${PN} += " installed-vs-shipped"
