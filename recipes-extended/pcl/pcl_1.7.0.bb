DESCRIPTION = "The Point Cloud Library (or PCL) for point cloud processing."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=5b8a2a1aa14e6de44b4273134946a34c"

DEPENDS = "boost libflann libeigen libusb1 libpng qhull"

SRC_URI = "https://github.com/PointCloudLibrary/${PN}/archive/${P}.tar.gz"
SRC_URI[md5sum] = "e2ac2d2e72825d991c6d194f9586b5d8"
SRC_URI[sha256sum] = "a5446b4d892d0e6b080ab6b6b745faad2f2f415c6c1353b1424f6b38175c777e"

SRC_URI += "file://0001-Fix-incompatibility-with-Boost-1.56.patch"

S = "${WORKDIR}/pcl-${P}"

EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
  -DHAVE_MM_MALLOC_EXITCODE=0 \
  -DHAVE_POSIX_MEMALIGN_EXITCODE=0 \ 
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.2", "-DHAVE_SSE4_2_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE4_2_EXTENSIONS_EXITCODE=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.1", "-DHAVE_SSE4_1_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE4_1_EXTENSIONS_EXITCODE=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse3", "-DHAVE_SSE3_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE3_EXTENSIONS_EXITCODE=1", d)} \ 
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse2", "-DHAVE_SSE2_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE2_EXTENSIONS_EXITCODE=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse", "-DHAVE_SSE_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE_EXTENSIONS_EXITCODE=1", d)} \
"

#Setting -ffloat-store to alleviate 32bit vs 64bit discrepancies on non-SSE platforms.
CXXFLAGS += "${@bb.utils.contains("TARGET_CC_ARCH", "-mfpmath=sse", "", "-ffloat-store", d)}"

inherit cmake

FILES_${PN}-dev += "${datadir}/${PN}-1.7/*.cmake"
