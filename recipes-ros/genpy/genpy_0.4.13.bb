DESCRIPTION = "Python ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg-native"
RDEPENDS_${PN} = "python-math genmsg python-shell"
RDEPENDS_${PN}_class-native = ""

PR = "r2"

SRC_URI = "https://github.com/ros/${BPN}/archive/${PV}.tar.gz;downloadfilename=${BP}.tar.gz \
           file://0001-genpy-extras.cmake.em-use-find_program-for-GENxxx_PY_BIN.patch"
SRC_URI[md5sum] = "201e3f1aa5e12ccc09159b1a3d9272f7"
SRC_URI[sha256sum] = "9dae768e9350c835ae8a40f19d230e3fe023bfc1e259a14be8b3ae7c4c632d3c"

inherit catkin
