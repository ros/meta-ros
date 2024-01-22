# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI = " \
  git://github.com/ros2-gbp/rig_reconfigure-release;name=release;${ROS_BRANCH};protocol=https \
  git://github.com/ocornut/imgui.git;name=upstream;destsuffix=git/imgui;branch=docking;protocol=https \
  file://0001-use-bitbake-fetcher.patch \
"

SRCREV_release = "5fc83827f67339d5bcf71cfc218d9e4574b15233"
SRCREV_upstream = "f8704cd085c4347f835c21dc12a3951924143872"
SRCREV_FORMAT = "release_upstream"

FILES:${PN} += "${datadir}/icons/hicolor/scalable/apps/rig_reconfigure.svg"
