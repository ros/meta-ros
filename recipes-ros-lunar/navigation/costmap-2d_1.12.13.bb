DESCRIPTION = "This package provides an implementation of a 2D costmap that takes in sensor data \
from the world, builds a 2D or 3D occupancy grid of the data (depending on whether a voxel based \
implementation is used), and inflates costs in a 2D costmap based on the occupancy grid and a user \
specified inflation radius."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "libeigen cmake-modules dynamic-reconfigure geometry-msgs laser-geometry map-msgs \
    message-filters message-generation nav-msgs pcl-conversions pcl-ros pluginlib roscpp \
    sensor-msgs std-msgs tf visualization-msgs voxel-grid"

require navigation.inc
