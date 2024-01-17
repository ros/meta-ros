# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "python3-numpy-native"

inherit python3native

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://make-cmake-target-relative.patch \
    file://add-missing-boost-include.patch \
"

# ERROR: hpp-fcl-2.1.3-1-r0 do_package: QA Issue: hpp-fcl: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/hpp-fcl
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# hpp-fcl: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"
