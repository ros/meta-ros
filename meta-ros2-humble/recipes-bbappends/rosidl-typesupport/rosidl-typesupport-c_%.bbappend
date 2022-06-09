# Copyright (c) 2019-2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'rosidl-typesupport-connext-c', '', d)}"
ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'rosidl-typesupport-opensplice-c', '', d)}"

# Deal with CMake Error while building recipe
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Deal-with-downstream-recipe-build-errors.patch \
"
# Fix for Honister release only:
inherit distutils3-base

# rosidl-typesupport-c: Files/directories were installed but not shipped in any package:
#   /usr/lib/librosidl_typesupport_c.so
FILES:${PN} += "${libdir}/lib*${SOLIBSDEV}"