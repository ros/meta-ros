LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0f34c2a8b1c102d683feca7a5835e921"

SRC_URI = "git://github.com/AcademySoftwareFoundation/Imath.git;protocol=https;branch=main"

PV = "3.1.9+git${SRCPV}"
SRCREV = "642312b48e4c054198a3887b9e4e53da08fb7531"

S = "${WORKDIR}/git"

DEPENDS = " \
   boost \
   python3-pybind11 \
"

inherit cmake python3native

BBCLASSEXTEND = "native nativesdk"
