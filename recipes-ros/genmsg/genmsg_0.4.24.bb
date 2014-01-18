DESCRIPTION = "Standalone Python library for generating ROS message and service data structures for various languages."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "11df24a3ff4467ec5de3fc752fb83292"
SRC_URI[sha256sum] = "3a13f51f338ee51c904d164bbc699244bf9d9afe4f2b3a1044c7b588c541bf48"

inherit catkin

RDEPENDS_${PN} = "python-stringold python-pprint"
RDEPENDS_${PN}_class-native = ""
