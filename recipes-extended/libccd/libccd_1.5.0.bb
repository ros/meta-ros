DESCRIPTION = "libccd is library for a collision detection between two convex shapes."
HOMEPAGE = "https://github.com/danfis/libccd"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://BSD-LICENSE;md5=ff7a32175d897961df3eec70a6166429"

SRC_URI = "http://libccd.danfis.cz/files/libccd-1.5.tar.gz"
SRC_URI[md5sum] = "461a8d57a7899074e197a8f0c05ed38e"
SRC_URI[sha256sum] = "676f937193090579ecddc5075adbcd963e3001d4ea4dc16b163031f50bc16130"

S = "${WORKDIR}/libccd-1.5"

EXTRA_OECMAKE += "-DCMAKE_BUILD_TYPE=Release -DCCD_DOUBLE=1"

inherit pkgconfig cmake
