DESCRIPTION = "Open Asset Import Library is a portable Open Source library to import \
               various well-known 3D model formats in a uniform manner."
HOMEPAGE = "http://www.assimp.org/"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d9d5275cab4fb13ae624d42ce64865de"

DEPENDS = "zlib"

SRC_URI = "git://github.com/assimp/assimp.git;protocol=https;branch=master"
UPSTREAM_CHECK_GITTAGREGEX = "v(?P<pver>(\d+(\.\d+)+))"

SRCREV = "8b9ed34eaa3e6ad24254cb7e058fb9150f66b865"

inherit cmake

EXTRA_OECMAKE = " \
    -DASSIMP_BUILD_ASSIMP_TOOLS=OFF \
    -DASSIMP_BUILD_TESTS=OFF \
    -DASSIMP_LIB_INSTALL_DIR=${baselib} \
    -DASSIMP_BUILD_ZLIB=ON \
"

# types.h:347:54: error: '<anonymous>' may be used uninitialized [-Werror=maybe-uninitialized]
CXXFLAGS += " -Wno-error=maybe-uninitialized"
# code/AssetLib/X3D/X3DGeoHelper.cpp:194:20: error: array subscript -1 is outside array bounds of 'int [2305843009213693951]' [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"

BBCLASSEXTEND = "native nativesdk"
