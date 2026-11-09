DESCRIPTION = "\
    The OpenEXR project provides the specification and reference \
    implementation of the EXR file format, \
    the professional-grade image storage format of the motion picture industry."
HOMEPAGE = "https://openexr.com/en/latest/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=b0f98dc4bafd54ae93bbd833040c68a3"

DEPENDS += "\
    doxygen \
    imath \
    libdeflate \
    zstd \
"

SRC_URI = "\
    git://github.com/AcademySoftwareFoundation/openexr.git;protocol=https;branch=RB-3.5;tag=v${PV} \
    file://run-ptest \
"

SRCREV = "3950290530c4fd4776667d0dc4d65a9d003eb936"

inherit cmake python3-dir python3native pkgconfig ptest

# These ptest use ctest (provided by cmake)
RDEPENDS:${PN}-ptest += "cmake"
# Build tests only if ptest is enabled
EXTRA_OECMAKE += "${@bb.utils.contains('PTEST_ENABLED', '1', '-DBUILD_TESTING=ON', '', d)}"

# set the path to the *.exr test file on the target
OECMAKE_CXX_FLAGS:append = ' -DILM_IMF_TEST_IMAGEDIR=\\\\\"${PTEST_PATH}/exr/OpenEXRTest/\\\\\"'

do_install_ptest() {
    install -d ${D}${PTEST_PATH}
    install -m 0755 ${B}/bin/IexTest ${D}${PTEST_PATH}/
    install -m 0755 ${B}/bin/OpenEXRTest ${D}${PTEST_PATH}/
    install -m 0755 ${B}/bin/OpenEXRCoreTest ${D}${PTEST_PATH}/
    install -m 0755 ${B}/bin/OpenEXRUtilTest ${D}${PTEST_PATH}/

    # images the tests read at runtime
    install -d ${D}${PTEST_PATH}/exr/OpenEXRTest
    install -m 0644 ${S}/src/test/OpenEXRTest/*.exr ${D}${PTEST_PATH}/exr/OpenEXRTest/
}

BBCLASSEXTEND = "native nativesdk"
