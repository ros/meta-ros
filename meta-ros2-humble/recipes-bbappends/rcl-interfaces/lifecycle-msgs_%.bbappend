# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    rosidl-default-runtime \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "lifecycle_msgs"
FILES:${PN} += " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
"