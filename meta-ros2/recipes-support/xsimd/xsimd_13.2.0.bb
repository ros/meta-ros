DESCRIPTION = "C++ wrappers for SIMD intrinsics and parallelized, optimized mathematical functions (SSE, AVX, AVX512, NEON, SVE)"
HOMEPAGE = "https://github.com/xtensor-stack/xsimd"
LICENSE = "BSD-3-Clause"

inherit cmake

#PR = "r1"

LIC_FILES_CHKSUM = "file://LICENSE;md5=fdd4d7dc8bdd9ae7181dd0bca68007a2"

SRC_URI = "git://github.com/xtensor-stack/xsimd.git;protocol=https;branch=master"

SRCREV = "1f8dd9c8e162968d9b4ff0251c56d431b8777f36"

BBCLASSEXTEND = "native nativesdk"
