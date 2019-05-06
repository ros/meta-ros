DESCRIPTION = "kdl_parser_py provides Python tools to construct a KDL tree from an XML robot representation in URDF."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=16;endline=16;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "orocos-kdl urdf"

require kdl-parser.inc

RDEPENDS_${PN} = "urdfdom-py python-orocos-kdl"
