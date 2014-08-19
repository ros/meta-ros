DESCRIPTION = "navfn provides a fast interpolated navigation function that can be used to create \
plans for a mobile base."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=19;endline=19;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "costmap-2d geometry-msgs nav-core nav-msgs pcl-conversions pcl-ros \
    pluginlib rosconsole roscpp tf visualization-msgs"

require navigation.inc
