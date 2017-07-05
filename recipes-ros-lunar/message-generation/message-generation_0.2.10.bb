DESCRIPTION = "Package modeling the build-time dependencies for generating language bindings of messages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "gencpp genlisp genmsg genpy"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "2bd63c01f909baba3a4b0737ae5e55dd"
SRC_URI[sha256sum] = "c653fa7c0eed41d85afd20dc08cec0474d191ed4afe4d90b7e38ff784b310501"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
