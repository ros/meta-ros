DESCRIPTION = "Planning components of MoveIt that use ROS"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "moveit-core moveit-ros-perception dynamic-reconfigure ${PYTHON_PN}-rospkg libtinyxml"

require moveit.inc

ROS_BPN = "moveit_ros/planning"

SRC_URI =+ "${@'file://0001-call-python3-for-dynamic-reconfigurations.patch' if d.getVar('PYTHON_PN', True) == 'python3' else ''}"

FILES_${PN} += "${ros_libdir}/moveit_ros_planning/*"
