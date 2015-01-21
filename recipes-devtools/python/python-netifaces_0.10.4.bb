DESCRIPTION = "Portable network interface information for Python"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=a53cbc7cb75660694e138ba973c148df"
SRCNAME = "netifaces"

SRC_URI = "https://pypi.python.org/packages/source/n/netifaces/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "36da76e2cfadd24cc7510c2c0012eb1e"
SRC_URI[sha256sum] = "9656a169cb83da34d732b0eb72b39373d48774aee009a3d1272b7ea2ce109cde"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
