DESCRIPTION = "The manipulation_msgs package"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "actionlib-msgs geometry-msgs sensor-msgs shape-msgs household-objects-database-msgs"

SRC_URI = "https://github.com/ros-interactive-manipulation/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "48bb43443982dc6c78afaf2b65a74e67"
SRC_URI[sha256sum] = "b34fae176367ff727876959e5f40eafeb9a7c158424bc288ae7eb9045e6b3a41"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
