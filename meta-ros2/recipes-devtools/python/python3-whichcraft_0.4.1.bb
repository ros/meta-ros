SUMMARY = "cross-platform cross-python shutil.which"
HOMEPAGE = "https://github.com/cookiecutter/whichcraft"
DESCRIPTION = "This package provides cross-platform cross-python shutil.which functionality."
SECTION = "devel/python"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=10aeddeae59172e5b47b6904402e5299"

S = "${WORKDIR}/git"
SRC_URI = "git://github.com/cookiecutter/whichcraft.git;protocol=https;branch=master"
SRCREV = "fc0e2dcacd560713749cfa461b06b618b833de5b"

# inherit pypi
inherit ptest setuptools3

BBCLASSEXTEND = "native nativesdk"
