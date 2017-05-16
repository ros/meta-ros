DESCRIPTION = "rosbridge provides a JSON interface to ROS, allowing any client to send JSON to publish or subscribe to ROS topics, call ROS services, and more"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=9add477069b61b5ccb4bac92ed431631"

DEPENDS = "rosbridge-library rosapi rospy rosauth"

RDEPENDS_${PN} = "rosauth rosbridge-library python-twisted"

require rosbridge-suite.inc
