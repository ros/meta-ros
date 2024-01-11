# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove_stomp_example.patch"

ROS_BUILD_DEPENDS = " \
    ros-industrial-cmake-boilerplate-native \
"

# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
# ERROR: stomp-0.1.2-1-r0 do_package: QA Issue: stomp: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/stomp
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# stomp: 4 installed and not shipped files. [installed-vs-shipped]
FILES:${PN}:prepend = " \
    ${datadir}/ament_index/resource_index/packages/stomp \
"
