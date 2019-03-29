SUMMARY = "Commonly needed Python modules, used by Python software developed at OSRF."
HOMEPAGE = "https://github.com/osrf/osrf_pycommon"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6c4db32a2fa8717faffa1d4f10136f47"

SRCREV = "e32de70e8b42dcd96bb66d29ddfb62e7fd8b795e"
SRC_URI = "git://github.com/osrf/osrf_pycommon.git;protocol=git;"

S = "${WORKDIR}/git"

inherit setuptools3

BBCLASSEXTEND += "native"
