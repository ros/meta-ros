DESCRIPTION = "Localization Manager helps to localize robot's position with annotated information"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roslint"

require yujin-ocs.inc

RDEPENDS_${PN} = "rospy actionlib ar-track-alvar ar-track-alvar-msgs geometry-msgs std-msgs yocs-msgs dynamic-reconfigure tf"
