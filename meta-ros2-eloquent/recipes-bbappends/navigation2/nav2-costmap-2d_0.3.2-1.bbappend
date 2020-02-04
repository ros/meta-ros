# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "eigen3-cmake-module"

do_install_append() {
    # Move it to existing ROS_BPN subdirectory to prevent conflict with nonpersistent-voxel-layer
    mv ${D}${datadir}/costmap_plugins.xml ${D}${datadir}/${ROS_BPN}/ 
}
