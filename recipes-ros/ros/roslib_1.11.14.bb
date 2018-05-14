DESCRIPTION = "Base dependencies and support libraries for ROS."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "boost rospack"

require ros.inc

ROS_PKG_SUBDIR = "core"

SRC_URI += "file://0001-use-env-to-get-python-exec.patch;striplevel=3"

RDEPENDS_${PN} = "${PYTHON_PN}-rospkg catkin-runtime"
