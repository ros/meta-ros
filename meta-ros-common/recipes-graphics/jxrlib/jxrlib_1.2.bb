LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea034eb982f97aff03a4704f608ed2b4"

SRC_URI = " \
    git://salsa.debian.org/debian-phototools-team/jxrlib.git;protocol=https;branch=master \
    file://usecmake.patch \
    file://typos.patch \
    file://cp1251.patch \
    file://bug771912.patch \
    file://bug803743.patch \
    file://bump_version.patch \
    file://pkg-config.patch \
    file://pie.patch \
    file://082bb032be1f6c75173bf603252e4f37bfded9fa.patch \
    file://31df7f88539b77d46ebf408b6a215930ae63bbdd.patch \
    file://a684f95783f2f81bd13bf1f8b03ceb12aa87d661.patch \
    file://ab9c6b78b7ad3205bdb91ef725b09ddbe3c8945d.patch \
    file://remove-hardcoded-defaults.patch \
"

# Modify these as desired
PV = "1.2+git${SRCPV}"
SRCREV = "1b84578fa80eae689c2677970cda64f53953880b"

S = "${WORKDIR}/git"

inherit cmake

# JXRGlueJxr.c:66:48: error: implicit declaration of function 'wcslen' [-Wimplicit-function-declaration]
CFLAGS += "-Wno-error=implicit-function-declaration"

# JXRTest.c:211:33: error: passing argument 2 of 'GetTestDecodeIID' from incompatible pointer type [-Wincompatible-pointer-types]
CFLAGS += "-Wno-error=incompatible-pointer-types"

BBCLASSEXTEND = "native nativesdk"
