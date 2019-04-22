# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/nav2-costmap-2d:"

SRC_URI += " \
    file://0001-Fix-build-errors.patch \
"

do_install_append() {
    # Duplicate of file under datadir/ROS_BPN/
    rm -f ${D}${datadir}/costmap_plugins.xml
}
