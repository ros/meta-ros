LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=b0f98dc4bafd54ae93bbd833040c68a3"

SRC_URI = "git://github.com/AcademySoftwareFoundation/openexr.git;protocol=https;branch=main"

PV = "3.2.1+git${SRCPV}"
SRCREV = "6258740337bf3859ed8abcf8d99a1671b2cdd06d"

S = "${WORKDIR}/git"

DEPENDS += " \
    doxygen \
    libdeflate \
    imath \
    clang-native \
"

inherit cmake python3-dir python3native pkgconfig

BBCLASSEXTEND = "native nativesdk"
