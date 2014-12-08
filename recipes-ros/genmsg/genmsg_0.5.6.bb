DESCRIPTION = "Standalone Python library for generating ROS message and service data structures for various languages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "df017d0804f4fb2bb79a2579635451ee"
SRC_URI[sha256sum] = "70ec083888f8bbdc32cf6b97cdbc3ccc042fe78ad2e6f6fc60b414aaffd8fba6"

inherit catkin

RDEPENDS_${PN} = "python-stringold python-pprint"
RDEPENDS_${PN}_class-native = ""
