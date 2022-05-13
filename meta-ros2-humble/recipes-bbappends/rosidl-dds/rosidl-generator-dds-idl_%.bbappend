# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "rosidl_generator_dds_idl"
FILES:${PN} += " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}-0.8.1-py3.9.egg-info \    
"