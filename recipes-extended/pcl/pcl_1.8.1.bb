DESCRIPTION = "The Point Cloud Library (or PCL) for point cloud processing."
SECTION = "devel"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=5b8a2a1aa14e6de44b4273134946a34c"

DEPENDS = "boost libflann libeigen qhull"

SRC_URI = "https://github.com/PointCloudLibrary/${PN}/archive/${P}.tar.gz"
SRC_URI[md5sum] = "436704215670bb869ca742af48c749a9"
SRC_URI[sha256sum] = "5a102a2fbe2ba77c775bf92c4a5d2e3d8170be53a68c3a76cfc72434ff7b9783"

#SRC_URI += "file://0001-make-the-pcl-library-compile-with-gcc6.patch"
SRC_URI += "file://0001-Dereference-shared_ptr-fix-for-GCC8.patch"

S = "${WORKDIR}/pcl-${P}"

EXTRA_OECMAKE += "\
  -DCMAKE_SKIP_RPATH=ON \
  -DHAVE_MM_MALLOC_EXITCODE=0 \
  -DHAVE_POSIX_MEMALIGN_EXITCODE=0 \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.2", "-DHAVE_SSE4_2_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE4_2_EXTENSIONS_EXITCODE=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse4.1", "-DHAVE_SSE4_1_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE4_1_EXTENSIONS_EXITCODE=1", d)} \
  -DHAVE_SSSE3_EXTENSIONS_EXITCODE=0 \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse3", "-DHAVE_SSE3_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE3_EXTENSIONS_EXITCODE=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse2", "-DHAVE_SSE2_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE2_EXTENSIONS_EXITCODE=1", d)} \
   ${@bb.utils.contains("TARGET_CC_ARCH", "-msse", "-DHAVE_SSE_EXTENSIONS_EXITCODE=0", "-DHAVE_SSE_EXTENSIONS_EXITCODE=1", d)} \
  -DWITH_LIBUSB=FALSE \
  -DWITH_PNG=FALSE \
  -DWITH_QHULL=TRUE \
  -DWITH_CUDA=FALSE \
  -DWITH_QT=FALSE \
  -DWITH_VTK=FALSE \
  -DWITH_PCAP=FALSE \
  -DWITH_OPENGL=FALSE \
"

#Setting -ffloat-store to alleviate 32bit vs 64bit discrepancies on non-SSE platforms.
CXXFLAGS += "${@bb.utils.contains("TARGET_CC_ARCH", "-mfpmath=sse", "", "-ffloat-store", d)}"

inherit cmake

FILES_${PN}-dev += "${datadir}/${PN}-1.8/*.cmake"

# The build is really memory hungry (at least with gcc8), even with just -j 8 it triggers OOMK on system with 32GB ram
# High memory needs mentioned in: https://github.com/PointCloudLibrary/pcl/issues/2284
# Setting just empty doesn't work, ninja will by default use number of cores available
# However, quick experiments have shown that it's possible to use up to CEIL(<RAM-in-GB>/5) as the argument to -j without running
# out of memory as long as the machine has a few GB of swap spacce => override the setting here by setting
# PARALLEL_MAKE_pn-pcl in conf/local.conf .
PARALLEL_MAKE = "-j1"

# Fixes this:
# | fatal error: stdlib.h: No such file or directory
# |   #include_next <stdlib.h>
do_configure_append() {
    if [ -e ${B}/build.ninja ]; then
        sed -i -e 's/-isystem /-I/g' ${B}/build.ninja
    else
        grep -rl -- '-isystem ' ${B} | xargs sed -i -e 's/-isystem /-I/g'
    fi
}
