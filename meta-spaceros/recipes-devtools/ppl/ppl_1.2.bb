LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

SRC_URI = "https://support.bugseng.com/ppl/download/ftp/releases/${PV}/ppl-${PV}.tar.bz2"
SRC_URI[sha256sum] = "2d470b0c262904f190a19eac57fb5c2387b1bfc3510de25a08f3c958df62fdf1"

inherit perlnative autotools

DEPENDS = "gmp"

AUTOTOOLS_AUTORECONF = "no"

do_configure() {
    oe_runconf
}
