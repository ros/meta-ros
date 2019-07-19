DESCRIPTION = "libccd is library for a collision detection between two convex shapes."
HOMEPAGE = "https://github.com/danfis/libccd"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://BSD-LICENSE;md5=ff7a32175d897961df3eec70a6166429"

SRC_URI = "https://github.com/danfis/libccd/archive/v1.5.tar.gz"
SRC_URI[md5sum] = "092ae20c4e139e60cb12e13edf4e14b1"
SRC_URI[sha256sum] = "686f2dd7a042fd75a3d88aff728bbabaebece727747aa18bb7f6f5e247831a95"

S = "${WORKDIR}/libccd-1.5"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DCCD_DOUBLE=1"

inherit pkgconfig cmake
