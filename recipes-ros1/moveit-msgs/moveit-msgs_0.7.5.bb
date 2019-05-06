DESCRIPTION = "Messages, services and actions used by MoveIt"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=14;endline=14;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation std-msgs trajectory-msgs geometry-msgs sensor-msgs actionlib-msgs octomap-msgs object-recognition-msgs"

SRC_URI = "https://github.com/ros-planning/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "60f559b7501006c2e021271ceef771b0"
SRC_URI[sha256sum] = "170b74b99c54fcf0334df2c4b0ecef84007d3bc0be7f9c530e69edf391320b4c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
