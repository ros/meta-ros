# POCO C++ libraries build file

DESCRIPTION="POCO C++ Libraries"
HOMEPAGE="http://pocoproject.org"
LICENSE="BSL-1.0"
LIC_FILES_CHKSUM="file://LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c"
DEPENDS="expat zlib pcre"

SRC_URI = "${SOURCEFORGE_MIRROR}/poco/poco-${PV}-all.tar.bz2 \
           file://OE"
SRC_URI[md5sum] = "2598b53d481e2bd3fb92bd23172abe53"
SRC_URI[sha256sum] = "95af0382257614c70841629c928184cddc228831a8bfc4c57399931bed8a16f8"

S = "${WORKDIR}/poco-${PV}-all"

inherit autotools binconfig pkgconfig

TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OECONF += "--config=OE \
                --no-samples \
                --no-wstring \
                --no-tests \
                --unbundled \
                --omit=Data/MySQL,Data/SQLite,Data/ODBC,PageCompiler \
                "

do_configure_prepend() {
    install ${WORKDIR}/OE ${S}/build/config/OE
    export POCO_TARGET_OSARCH=${TARGET_ARCH}
}

# not in the mood to fix the rpath badness, we do not need those files anyway
