DESCRIPTION = "This package defines messages for commonly used sensors, including \
cameras and scanning laser rangefinders."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "geometry-msgs"

require common-msgs.inc

RDEPENDS_${PN} += "geometry-msgs"
