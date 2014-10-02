DESCRIPTION = "This package provides an implementation of the Dynamic Window Approach to local \
robot navigation on a plane."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=20;endline=20;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "base-local-planner costmap-2d dynamic-reconfigure libeigen nav-core \
    nav-msgs pluginlib pcl-conversions roscpp tf"

require navigation.inc
