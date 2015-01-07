DESCRIPTION = "ROS Arduino Python"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

require ros-arduino-bridge.inc

RDEPENDS_${PN} = "rospy std-msgs sensor-msgs geometry-msgs nav-msgs tf ros-arduino-msgs python-pyserial"
