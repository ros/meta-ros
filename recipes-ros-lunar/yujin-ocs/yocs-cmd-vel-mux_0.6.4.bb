DESCRIPTION = "A multiplexer for command velocity inputs."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp nodelet dynamic-reconfigure pluginlib geometry-msgs yaml-cpp ${PYTHON_PN}-rospkg"

require yujin-ocs.inc
