# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'rosidl-typesupport-connext-cpp', '', d)}"
ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'rosidl-typesupport-opensplice-cpp', '', d)}"

DEPENDS += "rosidl-cmake"

# Deal with CMake Error while building recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-CMake-Error-while-building-recipe.patch \
"

# Fix for Honister release only:
inherit distutils3-base

# QA Issue: rosidl-typesupport-cpp: Files/directories were installed but not shipped in any package:
#   /usr/lib/librosidl_typesupport_cpp.so
FILES:${PN} += "${libdir}/lib*${SOLIBSDEV}"