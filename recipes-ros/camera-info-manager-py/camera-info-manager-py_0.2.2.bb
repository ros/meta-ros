DESCRIPTION = "Python interface for camera calibration information."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rospy sensor-msgs"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${ROS_SP}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "92ad0ca87343bb6fa4b7da5b54ce691e"
SRC_URI[sha256sum] = "925545b955cc4eab45791ba788439324ebdba8958c6cbcdee57b6fe4f62eec78"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "sensor-msgs"
