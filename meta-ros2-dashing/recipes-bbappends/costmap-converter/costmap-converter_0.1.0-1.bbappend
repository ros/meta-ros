# Copyright (c) 2020 LG Electronics, Inc.

do_install_append() {
    # Move it to existing ROS_BPN subdirectory
    mv ${D}${datadir}/plugins.xml ${D}${datadir}/${ROS_BPN}/          
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Make-it-compatible-with-OpenCV-4.patch"
