DESCRIPTION = "This unary stack contains the dynamic_reconfigure package which provides a means to \
change node parameters at any time without having to restart the node."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp std-msgs roslib"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "5728cc591b90e7ddd42b936e74e3062c"
SRC_URI[sha256sum] = "f1b073c36fd937bd8697bc92ec38926f9194069e6e8d80ab70eb09610720ee7f"

SRC_URI += "file://0001-address-gcc6-build-error.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RDEPENDS_${PN} = "roslib rosservice"
