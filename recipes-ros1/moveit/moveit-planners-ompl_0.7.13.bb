DESCRIPTION = "MoveIt interface to OMPL"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "moveit-core moveit-ros-planning ompl"

require moveit.inc

ROS_BPN = "moveit_planners/ompl"

FILES_${PN} += "${ros_libdir}/moveit_planners_ompl/*"
