DESCRIPTION = "This package contains a number of URDF tutorials."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "urdf"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "00ca53e1f00b58f39d3ca89cca1819a7"
SRC_URI[sha256sum] = "ac6c1d666eae7987ace46bab78dc9cc837a17462e59a80574d5441d0653cf333"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
