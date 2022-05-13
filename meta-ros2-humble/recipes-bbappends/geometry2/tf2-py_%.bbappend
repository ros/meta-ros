# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

ROS_BUILDTOOL_DEPENDS += " \
    python3-numpy-native \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "tf2_py"
FILES:${PN} += " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}-0.25.0-py3.9.egg-info \
"