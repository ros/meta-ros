LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/gz-msgs.git;protocol=https;branch=gz-msgs11 \
           file://override-generator-scripts.patch"

SRCREV = "21a942be1223e08c9b42c5aefb29e0414e9ddd2a"

S = "${WORKDIR}/git"

inherit cmake

FILES:${PN} += " \
    ${datadir}/gz \
    ${libdir}/python/gz \
    ${libdir}/ruby/gz \
"
