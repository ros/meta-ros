DESCRIPTION = "rosbridge provides a JSON interface to ROS, allowing any client to send JSON to publish or subscribe to ROS topics, call ROS services, and more"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=67aef562572a41111c8c17f1079a2869"

DEPENDS = "rosbridge-server rosbridge-library rosapi"

require rosbridge-suite.inc
