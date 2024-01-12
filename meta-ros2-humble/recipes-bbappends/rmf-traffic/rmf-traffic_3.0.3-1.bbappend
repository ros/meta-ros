# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-schedule-fix-get_participant-declaration-to-match-Vi.patch"

# ERROR: rmf-traffic-2.0.0-2-r0 do_package: QA Issue: rmf-traffic: Files/directories were installed but not shipped in any package:
#  /usr/share/ament_index
#  /usr/share/ament_index/resource_index
#  /usr/share/ament_index/resource_index/packages
#  /usr/share/ament_index/resource_index/packages/rmf_traffic
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# rmf-traffic: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

