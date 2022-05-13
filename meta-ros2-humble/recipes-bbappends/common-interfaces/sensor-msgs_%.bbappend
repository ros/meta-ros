# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
    rosidl-adapter-native \
    rosidl-typesupport-fastrtps-cpp-native \
    rosidl-typesupport-fastrtps-c-native \
    python3-numpy-native \
    python3-lark-parser-native \
"

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
"

# ERROR: do_package: Files/directories were installed but not shipped in any package
#
PNQAFIX = "sensor_msgs"
FILES:${PN} += " \
    ${STAGING_DIR_NATIVE}${libdir}/python3.9/site-packages/${PNQAFIX} \
"