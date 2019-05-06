DESCRIPTION = "Several demos and launch-tests for the avahi based zero-configuration."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=9;endline=9;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "zeroconf-msgs zeroconf-avahi"

require zeroconf-avahi-suite.inc

RDEPENDS_${PN} = "avahi-daemon bash"
