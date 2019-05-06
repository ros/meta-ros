DESCRIPTION = "control_msgs contains base messages and actions useful for controlling robots. It \
provides representations for controller setpoints and joint and cartesian trajectories."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=12;endline=12;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation std-msgs trajectory-msgs geometry-msgs actionlib-msgs"

SRC_URI = "https://github.com/ros-controls/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5cecfc4a80df27ee0ec5046d6d8bf6fd"
SRC_URI[sha256sum] = "578be636504dc6ca895876eda36741fbf1ca4b0bb034904912f37729436d40df"

S = "${WORKDIR}/${ROS_SP}/${ROS_BPN}"

inherit catkin
