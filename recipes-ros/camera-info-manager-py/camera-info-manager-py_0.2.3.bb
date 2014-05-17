DESCRIPTION = "Python interface for camera calibration information."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=13;endline=13;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rospy sensor-msgs"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${ROS_SP}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "9d1ead73e678fa2f51a70a933b0bf017"
SRC_URI[sha256sum] = "0019dfc4b32d63c1392aa264aed2253c1e0c2fb09216f8e2cc269bbfb8bb49b5"

S = "${WORKDIR}/${ROS_SPN}-${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "sensor-msgs"
