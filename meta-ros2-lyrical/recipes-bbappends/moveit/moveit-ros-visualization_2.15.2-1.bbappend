# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://add-bullet-dependency.patch"

ROS_BUILD_DEPENDS += "\
    rviz-default-plugins \
"

ROS_BUILDTOOL_DEPENDS += "\
    rosidl-default-generators-native \
"

# This resolves the following error:
#   To use a cross-compiled Qt, please set the QT_HOST_PATH cache variable to
#   the location of your host Qt installation.
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}

FILES:${PN}-dev =+ "${ros_libdir}/lib*${SOLIBSDEV}"
