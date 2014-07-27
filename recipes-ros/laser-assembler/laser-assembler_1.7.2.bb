DESCRIPTION = "Provides nodes to assemble point clouds from either LaserScan or PointCloud messages"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation sensor-msgs message-filters tf roscpp filters laser-geometry pluginlib"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "1e0fe2d0b5fb26eca1e9137d64767419"
SRC_URI[sha256sum] = "de6637a229d84d6215dc0176ea05bc40c2eb2d8dec8ca520c4a29822f089e74a"

SRC_URI += "file://0001-make-rostest-in-CMakeLists-optional-ros-rosdistro-30.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
