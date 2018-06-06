DESCRIPTION = "CAN related message types."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "std-msgs genmsg message-generation"

RDEPENDS_${PN} = "std-msgs message-runtime"

require ros-canopen.inc
