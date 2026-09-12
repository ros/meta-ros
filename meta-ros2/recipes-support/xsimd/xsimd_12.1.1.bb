DESCRIPTION = "C++ wrappers for SIMD intrinsics and parallelized, optimized mathematical functions (SSE, AVX, AVX512, NEON, SVE)"
HOMEPAGE = "https://github.com/xtensor-stack/xsimd"
LICENSE = "BSD-3-Clause"

inherit cmake

#PR = "r1"

LIC_FILES_CHKSUM = "file://LICENSE;md5=fdd4d7dc8bdd9ae7181dd0bca68007a2"

SRC_URI = "git://github.com/xtensor-stack/xsimd.git;protocol=https;branch=master"

SRCREV = "c1247bffa8fc36de7380a5cd42673a3b32f74c97"

BBCLASSEXTEND = "native nativesdk"
