DESCRIPTION = "ROS Industrial libraries/plugins for filtering trajectories"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "trajectory-msgs moveit-ros-planning"

RDEPENDS_${PN} = "trajectory-msgs"

require industrial-core.inc
