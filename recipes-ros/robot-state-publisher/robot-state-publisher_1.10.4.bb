DESCRIPTION = "This package allows you to publish the state of a robot to tf."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=17;endline=17;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "libeigen kdl-parser rosconsole roscpp rostime sensor-msgs tf tf-conversions"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "579fe7b46c1b461b784aecf8e82ca769"
SRC_URI[sha256sum] = "3d3ef47bb0a1f3d0540bd9b00ae22d736ffa5e445600929fc311bbec4c98978c"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
