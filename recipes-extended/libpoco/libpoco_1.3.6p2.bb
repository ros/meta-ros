# POCO C++ libraries build file

DESCRIPTION="POCO C++ Libraries"
HOMEPAGE="http://pocoproject.org"
LICENSE="BSL-1.0"
LIC_FILES_CHKSUM="file://LICENSE;md5=e4224ccaecb14d942c71d31bef20d78c"
DEPENDS="expat zlib pcre"
SRC_URI="${SOURCEFORGE_MIRROR}/poco/poco-1.3.6p2-all.tar.bz2 \
         file://OE"
SRC_URI[md5sum] = "8f1a6c3511764167d39f1950da3fcb37"
SRC_URI[sha256sum] = "290c7f80827e509642f200b766e3709ef6ace0b6efadc832c9e879ac11830ae5"

S="${WORKDIR}/poco-${PV}-all"
PR = "r4"

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
