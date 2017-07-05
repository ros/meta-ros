DESCRIPTION = "Interaction management for human interactive agents in the concert."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "${PYTHON_PN}-catkin-pkg roslint"

require rocon-tools.inc

RDEPENDS_${PN} = "genpy ${PYTHON_PN}-rospkg rospy rocon-bubble-icons rocon-console rocon-icons \
  rocon-app-manager-msgs rocon-interaction-msgs rocon-python-comms rocon-python-utils \
  rocon-std-msgs rocon-uri std-msgs unique-id"
