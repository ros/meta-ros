# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove_duplicate_xml_files.patch"

# CMake Warning at .../slam-toolbox/2.6.6-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', 'cmake_qt5', '', d)}

# Could NOT find PkgConfig (missing: PKG_CONFIG_EXECUTABLE)
inherit pkgconfig

# Could not find a package configuration file provided by "rosidl_adapter"
# with any of the following names:
#
#     rosidl_adapterConfig.cmake
#     rosidl_adapter-config.cmake
ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"
