DESCRIPTION = "The move_base package provides an implementation of an action that, given a goal in \
the world, will attempt to reach it with a mobile base."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "actionlib base-local-planner clear-costmap-recovery costmap-2d dynamic-reconfigure \
    geometry-msgs message-generation  move-base-msgs nav-core navfn nav-msgs pluginlib roscpp \
    rospy rotate-recovery std-msgs std-srvs tf visualization-msgs"

require navigation.inc
