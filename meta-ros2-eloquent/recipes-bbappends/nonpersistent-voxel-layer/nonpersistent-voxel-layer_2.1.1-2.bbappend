# Copyright (c) 2020 LG Electronics, Inc.

do_install_append() {
    # Move it to existing ROS_BPN subdirectory to prevent conflict with nav2-costmap-2d
    mv ${D}${datadir}/costmap_plugins.xml ${D}${datadir}/${ROS_BPN}/          
    mv ${D}${datadir}/example ${D}${datadir}/${ROS_BPN}/          
}
