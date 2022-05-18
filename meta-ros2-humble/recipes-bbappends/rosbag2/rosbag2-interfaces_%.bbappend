# Copyright (c) 2021 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "rosbag2_interfaces"
do_install:append() {
    mkdir -p ${D}${libdir}/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX}* ${D}${libdir}/python3.9/site-packages/
    rm -r ${D}/home
}