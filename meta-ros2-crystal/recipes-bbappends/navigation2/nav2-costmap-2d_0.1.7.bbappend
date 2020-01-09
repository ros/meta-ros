# Copyright (c) 2019-2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://0001-Fix-build-errors.patch \
"

do_install_append() {
    # Duplicate of file under datadir/ROS_BPN/
    rm -f ${D}${datadir}/costmap_plugins.xml
}

# nav2-costmap-2d/0.1.7-r0/git/src/costmap_2d_ros.cpp:246:65: error: 'map_width_meters' may be used uninitialized in this function [-Werror=maybe-uninitialized]
# nav2-costmap-2d/0.1.7-r0/git/src/costmap_2d_ros.cpp:247:40: error: 'map_height_meters' may be used uninitialized in this function [-Werror=maybe-uninitialized]
CXXFLAGS += "-Wno-error=maybe-uninitialized"
