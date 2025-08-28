SUMMARY = "OpenVDB - Sparse volume data structure and tools"
DESCRIPTION = "C++ library comprising a novel hierarchical data structure \
and a suite of tools for the efficient storage and manipulation of sparse \
volumetric data discretized on three-dimensional grids."
HOMEPAGE = "https://www.openvdb.org/"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://openvdb/openvdb/COPYRIGHT;md5=6b7f72a8d3f1cc39ccf8d9fa3bf42f24 \
                    file://openvdb/openvdb/LICENSE;md5=e23fadd6ceef8c618fc1c65191d846fa"

SRC_URI = "git://github.com/AcademySoftwareFoundation/openvdb.git;protocol=https;branch=master"

SRCREV = "166946c0365b16da7b2114e37f1187ab5ecd0916"

S = "${WORKDIR}/git"

DEPENDS = "imath tbb log4cplus blosc zlib"

inherit cmake pkgconfig

EXTRA_OECMAKE = " \
    -DCONCURRENT_MALLOC=Tbbmalloc \
    -DOPENVDB_BUILD_BINARIES=OFF \
    -DUSE_BLOSC=ON \
    -DUSE_ZLIB=ON \
    -DUSE_IMATH_HALF=ON \
    -DUSE_LOG4CPLUS=ON \
"
