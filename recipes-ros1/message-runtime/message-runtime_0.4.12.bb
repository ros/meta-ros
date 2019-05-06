DESCRIPTION = "Package modeling the run-time dependencies for language bindings of messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "gencpp cpp-common roscpp-serialization"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "d32e58fd60f775e015b9572e397da891"
SRC_URI[sha256sum] = "7863e3e9c47c57f93f8c82e3439081da07454f1e2a4d07e0c29aacc139855806"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
