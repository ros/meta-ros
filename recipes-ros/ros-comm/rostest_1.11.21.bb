DESCRIPTION = "Integration test suite based on roslaunch that is compatible with xUnit frameworks."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost ${PYTHON_PN}-nose"
DEPENDS_class-native = "boost-native rosunit-native"

require ros-comm.inc

ROS_PKG_SUBDIR = "tools"

OECMAKE_EXTRA_ROOT_PATH_class-native = "${OECMAKE_BUILDPATH}/devel"
