DESCRIPTION = "library to compute convex hulls, Delaunay triangulations and Voronoi diagrams."
HOMEPAGE = "http://www.qhull.org/"
SECTION = "libs"
LICENSE = "Qhull"
LIC_FILES_CHKSUM = "file://COPYING.txt;md5=6cf68697da2f499f1207c84dc319b727"

SRC_URI = "http://www.qhull.org/download/qhull-2015-src-7.2.0.tgz"
SRC_URI[sha256sum] = "78b010925c3b577adc3d58278787d7df08f7c8fb02c3490e375eab91bb58a436"

CFLAGS += "-fPIC"

EXTRA_OECMAKE += "\
    -DCMAKE_SKIP_RPATH=ON \
"

inherit cmake
