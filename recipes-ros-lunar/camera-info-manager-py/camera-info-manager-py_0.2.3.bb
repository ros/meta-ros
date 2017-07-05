DESCRIPTION = "Python interface for camera calibration information."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rospy sensor-msgs"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${ROS_SP}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "eb12065f8e6b9d06a489f89f19dcc41e"
SRC_URI[sha256sum] = "d1ae6229c9a55e8d6fa89b5d051b86605fca0b02ff2e344c76c44d7642eb88c6"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "sensor-msgs"
