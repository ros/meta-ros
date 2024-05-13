LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-cmake.git;protocol=https;branch=gz-cmake3"

SRCREV = "ddd38ff196640024d6e054ff59cf5fea1ef01d73"

S = "${WORKDIR}/git"

FILES:${PN} += "${datadir}/gz/gz-cmake3/*"
inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""

FILES:${PN}-dev += " \
    pkgconfig/gz-cmake3.pc \
    ${includedir} \
    ${datadir}/cmake/gz-cmake3/cmake3/ \
    ${datadir}/gz/gz-cmake3/ \
"

BBCLASSEXTEND = "native nativesdk"
