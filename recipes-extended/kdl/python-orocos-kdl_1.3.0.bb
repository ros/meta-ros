DESCRIPTION = "This package contains the python bindings PyKDL for the Kinematics and Dynamics Library (KDL), distributed by the Orocos Project."
SECTION = "devel"
LICENSE = "LGPLv2"
LIC_FILES_CHKSUM = "file://package.xml;beginline=10;endline=10;md5=46ee8693f40a89a31023e97ae17ecf19"

DEPENDS = "sip-native sip orocos-kdl"

require kdl.inc

inherit pythonnative

FILES_${PN} += "${libdir}/python*/dist-packages/PyKDL.so"
FILES_${PN}-dev += "${datadir}/python_orocos_kdl/*"
FILES_${PN}-dbg += "${libdir}/python*/dist-packages/.debug/*"

RDEPENDS_{PN} = "python-sip"
