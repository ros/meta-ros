DESCRIPTION = "This package contains a number of URDF tutorials."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=5ee5b8b046ae48ad94a2037ca953a67b"

DEPENDS = "urdf"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "b4f889f4c6c1cf70e89c2014d66d8ab4"
SRC_URI[sha256sum] = "52cc8a8ddd562f84f41b655c4600adb8986314b657a372d32f868ea14e49d485"

S = "${WORKDIR}/${ROS_SP}"

inherit catkin
