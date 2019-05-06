DESCRIPTION = "Service pair libraries for pub/sub non-blocking services."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "${PYTHON_PN}-catkin-pkg"

require rocon-tools.inc

RDEPENDS_${PN} = "genpy rospy rosnode rosservice rostopic rosgraph roslib python-pyyaml \
  rocon-console rocon-service-pair-msgs unique-id uuid-msgs"
