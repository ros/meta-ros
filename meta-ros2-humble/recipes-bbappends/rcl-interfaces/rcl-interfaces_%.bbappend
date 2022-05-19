# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-parser-native \
    rosidl-adapter-native \
    python3-numpy-native \
    python3-lark-parser-native \
"

# Without the target rosidl-typesupport-{c,cpp}, ament finds the native packages and then fails to link (error: incompatible
# target).
ROS_BUILD_DEPENDS += " \
    rosidl-typesupport-c \
    rosidl-typesupport-cpp \
    fastrtps-cmake-module \
    rmw-fastrtps-cpp \
    rmw-fastrtps-shared-cpp \
    rmw-implementation \
    rmw-implementation-cmake \
    rosidl-generator-cpp \
    rosidl-typesupport-fastrtps-c \
    rosidl-typesupport-fastrtps-cpp \
    rosidl-typesupport-fastrtps-c-native \
    rosidl-typesupport-fastrtps-cpp-native \
"


# # ERROR: do_package: Files/directories were installed but not shipped in any package
# #
do_install:append:class-target() {
    mkdir -p ${D}/usr/lib/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}/usr/lib/python3.9/site-packages/${ROS_BPN}* ${D}/usr/lib/python3.9/site-packages/
    rm -r ${D}/home
}