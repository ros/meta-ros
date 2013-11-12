DESCRIPTION = "Converts a depth image to a laser scan for use with navigation and localization."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp sensor-msgs nodelet image-transport image-geometry dynamic-reconfigure"

SRC_URI = "https://github.com/ros-perception/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "ae007125db0a6586c176e0b111ae62c1"
SRC_URI[sha256sum] = "ae5ee31fc7cb9cd35dd3dd1b36ae00f084f874131d474466791bdb050cd7340f"

SRC_URI += "file://0001-check-for-CATKIN_ENABLE_TESTING.patch"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin

RRECOMMENDS_${PN} = "roscpp sensor-msgs nodelet image-transport image-geometry dynamic-reconfigure"
