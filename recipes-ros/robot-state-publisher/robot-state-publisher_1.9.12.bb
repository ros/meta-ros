DESCRIPTION = "This package allows you to publish the state of a robot to tf."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "libeigen kdl-parser rosconsole roscpp rostime sensor-msgs tf tf-conversions"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f5c83111084f72818d2a89b7c0a231fc"
SRC_URI[sha256sum] = "526579e94d679609ef4c10e4316d1455c6e21d8fcd69a98a3330d1322c94ff71"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
