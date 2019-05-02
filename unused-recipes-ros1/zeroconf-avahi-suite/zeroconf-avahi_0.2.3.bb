DESCRIPTION = "Provides zeroconf services on avahi for ros systems."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://package.xml;beginline=8;endline=8;md5=d566ef916e9dedc494f5f793a6690ba5"

DEPENDS = "rosconsole roscpp zeroconf-msgs avahi"

require zeroconf-avahi-suite.inc
