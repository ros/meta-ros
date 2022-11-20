SUMMARY = "This package provides cross-platform cross-python shutil.which functionality."
HOMEPAGE = "https://github.com/pydanny/whichcraft"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=10aeddeae59172e5b47b6904402e5299"

SRC_URI = "git://github.com/cookiecutter/whichcraft.git;protocol=https;branch=master"

# Modify these as desired
PV = "0.6.1+git${SRCPV}"
SRCREV = "4318da2e2a4cb1ae3928446e5e98e3eb958a80f9"

S = "${WORKDIR}/git"

inherit setuptools3

RDEPENDS:${PN} += "python3-core"
