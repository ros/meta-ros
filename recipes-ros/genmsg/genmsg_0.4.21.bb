DESCRIPTION = "Standalone Python library for generating ROS message and service data structures for various languages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

PR = "r2"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "03ff82b1efa75552d4a5a000e0576cc4"
SRC_URI[sha256sum] = "e7e4b23eadb97b0deca53874532c0b42f10f406a9db2affd7d6f04101a4a2901"

SRC_URI += "file://0001-resolve-path-of-message-file-and-include-dirs-in-ins.patch"

inherit catkin

RDEPENDS_${PN} = "python-stringold python-pprint"
RDEPENDS_${PN}_class-native = ""
