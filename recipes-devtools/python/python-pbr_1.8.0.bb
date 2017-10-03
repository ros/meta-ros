DESCRIPTION = "Python Build Reasonableness: PBR is a library that injects some useful and sensible default behaviors into your setuptools run"
HOMEPAGE = "https://pypi.python.org/pypi/pbr"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"

SRC_URI[md5sum] = "bc7173f5ccec8e6125e3b68f0285eb8a"
SRC_URI[sha256sum] = "44a0ef9295bb59698f461124741a21a0f7f76d42e160d8a0a4bf1693338036fc"

inherit pypi setuptools

RDEPENDS_${PN}_class-target += " \
        python-pip \
        "

BBCLASSEXTEND = "native"