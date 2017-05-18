DESCRIPTION = "The industrial robot simulator is a stand in for industrial robot driver node(s)"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=7;endline=7;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "std-msgs trajectory-msgs sensor-msgs industrial-msgs control-msgs"

RDEPENDS_${PN} = "industrial-robot-client"

require industrial-core.inc
