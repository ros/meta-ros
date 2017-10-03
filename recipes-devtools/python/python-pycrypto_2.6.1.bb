DESCRIPTION = "Cryptographic modules for Python."
HOMEPAGE = "http://www.pycrypto.org/"
SECTION = "devel/python"
LICENSE = "PSFv2"
LIC_FILES_CHKSUM = "file://COPYRIGHT;md5=35f354d199e8cb7667b059a23578e63d"

SRCNAME = "pycrypto"

SRC_URI = "https://pypi.python.org/packages/source/p/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://cross-compiling.patch"

SRC_URI[md5sum] = "55a61a054aa66812daf5161a0d5d7eda"
SRC_URI[sha256sum] = "f2ce1e989b272cfcb677616763e0a2e7ec659effa67a88aa92b3a65528f60a3c"

S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

export STAGING_INCDIR
export STAGING_LIBDIR
export BUILD_SYS
export HOST_SYS

inherit autotools autotools-brokensep distutils

DEPENDS += " gmp"

do_compile[noexec] = "1"

# We explicitly call distutils_do_install, since we want it to run, but
# *don't* want the autotools install to run, since this package doesn't
# provide a "make install" target.
do_install() {
	distutils_do_install
}
