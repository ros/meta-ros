DESCRIPTION = "Standalone Python library for generating ROS message and service data structures for various languages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "942b0151a038683254230cfed22dced6"
SRC_URI[sha256sum] = "d7627a2df169e4e8208347d9215e47c723a015b67ef3ed8cda8b61b6cfbf94d2"

inherit catkin

RDEPENDS_${PN} = "${PYTHON_PN}-stringold ${PYTHON_PN}-pprint"
RDEPENDS_${PN}_class-native = ""
