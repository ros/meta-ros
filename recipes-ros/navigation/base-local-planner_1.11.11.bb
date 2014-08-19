DESCRIPTION = "This package provides implementations of the Trajectory Rollout and Dynamic Window \
approaches to local robot navigation on a plane."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "angles costmap-2d dynamic-reconfigure geometry-msgs libeigen message-generation \
    nav-core nav-msgs pcl-conversions pcl-ros pluginlib rosconsole roscpp rospy std-msgs tf \
    voxel-grid visualization-msgs"

require navigation.inc
