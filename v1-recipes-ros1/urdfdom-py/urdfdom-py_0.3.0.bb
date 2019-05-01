DESCRIPTION = "A python library to access URDFs using the DOM model."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=b441202ba2d6b14d62026cb18bb960ed"

require urdfdom.inc

SRC_URI += "file://0001-urdf-parser-py-install-scripts-using-catkin_python_s.patch;striplevel=2"

S = "${WORKDIR}/${ROS_SP}/urdf_parser_py"

inherit catkin

RDEPENDS_${PN} = "${PYTHON_PN}-lxml"
