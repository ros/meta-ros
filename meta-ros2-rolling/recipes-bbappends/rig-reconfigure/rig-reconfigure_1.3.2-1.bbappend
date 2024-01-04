# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
  git://github.com/ocornut/imgui.git;name=upstream;destsuffix=git/imgui;branch=docking;protocol=https \
  file://0001-use-bitbake-fetcher.patch \
"

SRCREV_upstream = "f8704cd085c4347f835c21dc12a3951924143872"

FILES:${PN} += "${datadir}/icons/hicolor/scalable/apps/rig_reconfigure.svg"
