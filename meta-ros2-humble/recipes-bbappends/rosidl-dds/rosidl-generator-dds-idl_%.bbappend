# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "rosidl_generator_dds_idl"
do_install:append() {
    mkdir -p ${D}${libdir}/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}* ${D}${libdir}/python3.9/site-packages/
    rm -r ${D}/home
}