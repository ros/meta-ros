DESCRIPTION = "A ROS node that simply forwards odometry information."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "angles roscpp rosconsole nav-msgs geometry-msgs tf message-filters rospy"

require navigation.inc
