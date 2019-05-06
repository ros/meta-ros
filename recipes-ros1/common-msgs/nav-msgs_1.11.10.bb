DESCRIPTION = "nav_msgs defines the common messages used to interact with the navigation stack."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs geometry-msgs"

require common-msgs.inc

RDEPENDS_${PN} = "actionlib-msgs"
