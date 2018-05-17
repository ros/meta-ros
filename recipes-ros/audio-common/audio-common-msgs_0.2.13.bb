DESCRIPTION = "Messages for transmitting audio via ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=a3ae2ba3f0f44e61270955e8cd98afcf"

DEPENDS = "message-generation"

require audio-common.inc

RRECOMMENDS_${PN} += "message-runtime"
