# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-launch.git;protocol=https;branch=ign-launch5"

SRCREV = "894e2e2319617fbde652960b847e13436391ec9c"

S = "${WORKDIR}/git"

DEPENDS = "elfutils"

inherit cmake
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}

DEPENDS = " \
    elfutils \
    ignition-cmake2 \
    ignition-common4 \
    ignition-gazebo6 \
    ignition-gui6 \
    ignition-math6 \
    ignition-msgs8 \
    ignition-plugin \
    ignition-rendering6 \
    ignition-tools1 \
    ignition-transport11 \
    ignition-utils1 \
    libwebsockets \
"
