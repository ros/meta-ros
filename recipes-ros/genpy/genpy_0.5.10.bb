DESCRIPTION = "Python ROS message and service generators."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "genmsg"

SRC_URI = "https://github.com/ros/${ROS_SPN}/archive/${PV}.tar.gz;downloadfilename=${ROS_SP}.tar.gz"
SRC_URI[md5sum] = "f079b4c24bec3763e01cac2149fd31c9"
SRC_URI[sha256sum] = "e4465daffb352b4b45180a6157925b16ab3042996984ad231531134e4d144391"

inherit catkin

RDEPENDS_${PN} = "${PYTHON_PN}-math genmsg ${PYTHON_PN}-shell"
RDEPENDS_${PN}_class-native = ""
