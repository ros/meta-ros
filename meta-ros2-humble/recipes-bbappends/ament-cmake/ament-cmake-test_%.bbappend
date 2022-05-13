# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "ament_cmake_test"
FILES:${PN} += " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}-1.3.1-py3.9.egg-info \
"