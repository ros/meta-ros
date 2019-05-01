DESCRIPTION = "A multi-roslaunch (for single and multi-master systems)."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "${PYTHON_PN}-catkin-pkg"

require rocon-tools.inc

RDEPENDS_${PN} = "rospy roslaunch rocon-console rocon-python-utils rosbash"
