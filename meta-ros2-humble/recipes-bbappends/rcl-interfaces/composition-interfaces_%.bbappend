# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "composition_interfaces"
FILES:${PN} += " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
"