# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

require orocos-kdl.inc

# orocos-kdl appears in both ROS_BUILD_DEPENDS and ROS_EXPORT_DEPENDS, so it's easier to remove it from DEPENDS.
DEPENDS:remove = "orocos-kdl"
ROS_EXEC_DEPENDS:remove = "orocos-kdl"

# Instead of fetching a tarball
# during do_compile
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-orocos-kdl-with-bitbake-fetcher.patch \
    https://raw.githubusercontent.com/ros2/orocos_kdl_vendor/humble/orocos_kdl_vendor/0001-include_project_name.patch;name=patch;patchdir=orocos-kdl \
"

SRC_URI[patch.md5sum] = "0208162d10526b13e62a6cdef2dadc84"
SRC_URI[patch.sha256sum] = "bed98c6c2a0261488d522b80fc792fd3ad817b01d7344342f28a470bd140c481"

FILES:${PN}-dev += "${datadir}/orocos_kdl/cmake/*.cmake"

inherit ros_insane_dev_so
