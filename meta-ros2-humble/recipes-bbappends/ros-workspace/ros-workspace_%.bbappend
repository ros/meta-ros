# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS:remove = "ament-cmake-core"
ROS_BUILD_DEPENDS:remove = "ament-package"
ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-core-native \
    ament-package-native \
"

# The package find files from CMAKE_INSTALL_PREFIX that is just absolute "/usr".
# Need to pass the native sysroot folder path.
export STAGING_DIR_NATIVE
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI:append = " file://0001-Don-t-use-CMAKE_INSTALL_PREFIX-as-sysroot-for-cross-.patch"
