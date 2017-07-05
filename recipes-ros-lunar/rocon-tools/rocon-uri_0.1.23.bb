DESCRIPTION = "Module for working with rocon uri strings."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

require rocon-tools.inc

RDEPENDS_${PN} = "rocon-console rocon-ebnf rospy"
