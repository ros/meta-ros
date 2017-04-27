DESCRIPTION = "Core rocon apps for use with the appmanager and rocon concert."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

require rocon-app-platform.inc

RDEPENDS_${PN} = "bash gateway-msgs rocon-app-manager-msgs roslib rospy rospy-tutorials topic-tools"
