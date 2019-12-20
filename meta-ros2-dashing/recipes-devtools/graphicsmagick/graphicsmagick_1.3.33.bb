SUMMARY = "Swiss army knife of image processing"
HOMEPAGE = "http://www.graphicsmagick.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://Copyright.txt;md5=93c4d59582eec44dba74c2c65be2de25"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/GraphicsMagick-${PV}.tar.bz2"
SRC_URI[md5sum] = "403d58ad09245e8868d8d2035e170615"
SRC_URI[sha256sum] = "d18aaca2d79a10270d49ad1aaa01dce24752f7548880138d59874a78ac62e11f"

S = "${WORKDIR}/GraphicsMagick-${PV}"

inherit autotools

FILES_${PN} += "${datadir}/GraphicsMagick-1.3.33/config ${libdir}/GraphicsMagick-1.3.33/config"

EXTRA_OECONF += "--enable-static=no --enable-shared=yes"
