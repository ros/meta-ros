DESCRIPTION = "ROS messages for universally unique identifiers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation std-msgs"

require unique-identifier.inc

RDEPENDS_${PN} = "message-runtime"
