# Copyright (c) 2019 LG Electronics, Inc.

DESCRIPTION = "A python interface to Graphviz"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f5ce36373e1542c5b82d521315da8cc2"
SRCNAME = "pydot"

SRC_URI = "https://github.com/pydot/pydot/archive/v${PV}.tar.gz;downloadfilename=pydot_${PV}.tar.gz"
SRC_URI[md5sum] = "d369b567424d25456ea1efcde50bb2ce"
SRC_URI[sha256sum] = "3e70236381ed2b5778a4e173d46435396b2484ab0f4f31fd1219ec12d88e3e40"

S = "${WORKDIR}/${SRCNAME}-${PV}"

BBCLASSEXTEND = "native nativesdk"
