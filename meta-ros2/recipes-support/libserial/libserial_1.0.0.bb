LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=fdcb31da81c085fd445062a1eb929089"

SRC_URI = " \
    git://github.com/crayzeewulf/libserial;protocol=https;branch=master \
    file://use-system-googletest.patch \
"

PV = "1.0.0+git${SRCPV}"
SRCREV = "461b19e2f883574b9d52b3eb94d25847ebfbd85a"

DEPENDS = "boost doxygen-native gtest"

inherit cmake python3-dir

FILES:${PN} += "${libdir}/libserialmod.so"
FILES:${PN}-dev = "${includedir}/* ${libdir}/libserial.so"
