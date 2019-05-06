DESCRIPTION = "Defines a simple messaging connection and protocol for communicating with an industrial robot controller."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=11;endline=11;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "roscpp industrial-msgs"

RDEPENDS_${PN} = "industrial-msgs"

require industrial-core.inc

SRC_URI += "file://0001-Build-unit-tests-conditionally.patch"
