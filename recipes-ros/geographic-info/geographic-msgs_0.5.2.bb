DESCRIPTION = "ROS messages for Geographic Information Systems."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

RDEPENDS_${PN} = "std-msgs uuid-msgs geometry-msgs"

require geographic-info.inc
