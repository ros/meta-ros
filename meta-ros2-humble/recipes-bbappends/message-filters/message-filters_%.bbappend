# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

ROS_BUILDTOOL_DEPENDS += " \
    python3-numpy-native \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "message_filters"
FILES:${PN} += " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}-4.3.1-py3.9.egg-info \
"