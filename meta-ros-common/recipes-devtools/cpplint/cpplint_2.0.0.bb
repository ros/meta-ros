SUMMARY = "cpplint - static code checker for C++"
DESCRIPTION = "Automated checker to ensure C++ files follow Google's style guide"
HOMEPAGE = "https://github.com/cpplint/cpplint"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a58572e3501e262ddd5da01be644887d"

SRC_URI = "git://github.com/cpplint/cpplint;protocol=https;branch=develop"

PV = "2.0.0+git${SRCPV}"
SRCREV = "f4363d7fc0d5f38c4fd41b658e069e96583da0d5"


inherit setuptools3

RDEPENDS:${PN} += "python3-core python3-shell python3-stringold python3-xml"

BBCLASSEXTEND = "native nativesdk"
