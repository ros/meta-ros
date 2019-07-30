# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://0001-Fix-build-errors.patch \
"

do_install_append() {
    # Duplicate of file under datadir/ROS_BPN/
    rm -f ${D}${datadir}/costmap_plugins.xml
}
