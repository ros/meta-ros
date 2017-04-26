DESCRIPTION = "amcl is a probabilistic localization system for a robot moving in 2D."
SECTION = "devel"
LICENSE = "LGPL-2.1+"
LIC_FILES_CHKSUM = "file://package.xml;beginline=21;endline=21;md5=58d727014cda5ed405b7fb52666a1f97"

DEPENDS = "dynamic-reconfigure message-filters nav-msgs rosbag roscpp std-srvs tf ${PYTHON_PN}-rospkg"

require navigation.inc
