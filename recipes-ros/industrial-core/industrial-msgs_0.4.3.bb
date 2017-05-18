DESCRIPTION = "The industrial message package containes industrial specific messages definitions"
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "std-msgs trajectory-msgs genmsg message-generation"

RDEPENDS_${PN} = "trajectory-msgs"

require industrial-core.inc
