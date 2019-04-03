DESCRIPTION = "library to compute convex hulls, Delaunay triangulations and Voronoi diagrams."
HOMEPAGE = "http://www.qhull.org/"
SECTION = "libs"
LICENSE = "Qhull"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=4d4e8c0754b225e2c78cfdd911e8b09e"

SRC_URI = "http://www.qhull.org/download/qhull-${PV}-src.tgz \
    file://0001-testqset-fix-build-with-conf-distro-include-security.patch \
"
SRC_URI[md5sum] = "d0f978c0d8dfb2e919caefa56ea2953c"
SRC_URI[sha256sum] = "a35ecaa610550b7f05c3ce373d89c30cf74b059a69880f03080c556daebcff88"

CFLAGS += "-fPIC"

EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake
