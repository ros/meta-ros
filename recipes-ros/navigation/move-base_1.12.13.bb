DESCRIPTION = "The move_base package provides an implementation of an action that, given a goal in \
the world, will attempt to reach it with a mobile base."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "actionlib costmap-2d dynamic-reconfigure geometry-msgs message-generation move-base-msgs \
    nav-core nav-msgs pluginlib roscpp rospy std-msgs std-srvs tf visualization-msgs"

require navigation.inc
