DESCRIPTION = "Standalone Python library for generating ROS message and service data structures for various languages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f3be89c67caa87e1a8791f93de06f2c1"
SRC_URI[sha256sum] = "8ceecbf0b5274bd44bec48190425d46124660a4d92dbb6c5a9545f0594ffc54c"

inherit catkin

RDEPENDS_${PN} = "python-stringold python-pprint"
RDEPENDS_${PN}_class-native = ""
