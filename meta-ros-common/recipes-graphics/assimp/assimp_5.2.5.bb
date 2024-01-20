DESCRIPTION = "Open Asset Import Library is a portable Open Source library to import \
               various well-known 3D model formats in a uniform manner."
HOMEPAGE = "http://www.assimp.org/"
SECTION = "devel"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d9d5275cab4fb13ae624d42ce64865de"

DEPENDS = "zlib"

SRC_URI = "git://github.com/assimp/assimp.git;branch=master;protocol=https"
UPSTREAM_CHECK_GITTAGREGEX = "v(?P<pver>(\d+(\.\d+)+))"

SRCREV = "9519a62dd20799c5493c638d1ef5a6f484e5faf1"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = "-DASSIMP_BUILD_ASSIMP_TOOLS=OFF -DASSIMP_BUILD_TESTS=OFF -DASSIMP_LIB_INSTALL_DIR=${baselib}"

# error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' forming offset 4 is out of the bounds [0, 4] [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"

BBCLASSEXTEND = "native nativesdk"
