DESCRIPTION = "ROS package for the BeagleBone for ROS Serial Embedded Linux Examples."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "std-msgs sensor-msgs geometry-msgs nav-msgs rosserial-client"

require rosserial.inc
