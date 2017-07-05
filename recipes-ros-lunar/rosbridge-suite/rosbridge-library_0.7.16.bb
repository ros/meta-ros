DESCRIPTION = "rosbridge provides a JSON interface to ROS, allowing any client to send JSON to publish or subscribe to ROS topics, call ROS services, and more"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=68b329da9893e34099c7d8ad5cb9c940"

DEPENDS = "message-generation std-msgs geometry-msgs rospy python-six python-bson"

require rosbridge-suite.inc
