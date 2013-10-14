DESCRIPTION = " map_server provides the map_server ROS Node, which offers map data as a ROS Service."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=01c2bc31767ccb3a68e12f02612b2a97"

DEPENDS = "libsdl-image nav-msgs roscpp rostest tf yaml-cpp"

require navigation.inc

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch;striplevel=2"
