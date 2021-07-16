DESCRIPTION = "ros1-industrial-core package group"
LICENSE = "MIT"

inherit packagegroup

PACKAGES = "${PN}"

RDEPENDS:${PN} = "\
        industrial-trajectory-filters \
        industrial-robot-simulator \
        industrial-robot-client \
        industrial-utils \
"
