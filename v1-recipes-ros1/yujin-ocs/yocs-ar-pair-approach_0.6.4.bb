DESCRIPTION = "Search and approach behaviour, moving to a target in front of a pair of ar markers."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "dynamic-reconfigure geometry-msgs rospy std-msgs tf"

require yujin-ocs.inc

RDEPENDS_${PN} = "bash"
