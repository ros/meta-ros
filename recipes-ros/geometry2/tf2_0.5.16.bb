DESCRIPTION = "tf2 is the second generation of the transform library, which lets \
the user keep track of multiple coordinate frames over time."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "tf2-msgs geometry-msgs console-bridge rospy"

RDEPENDS_${PN} += "tf2-msgs geometry-msgs console-bridge rostime"

require geometry2.inc
