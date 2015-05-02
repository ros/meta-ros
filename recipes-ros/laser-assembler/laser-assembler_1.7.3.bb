DESCRIPTION = "Provides nodes to assemble point clouds from either LaserScan or PointCloud messages"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "message-generation sensor-msgs message-filters tf roscpp filters laser-geometry pluginlib"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f9a368c1ec64c47c3539ad2eb58e95e2"
SRC_URI[sha256sum] = "11c01b45917f9b9f24d19b38e8d32046da4f6deae479812b2326b7deb2a624f4"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
