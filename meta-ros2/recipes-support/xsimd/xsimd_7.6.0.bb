DESCRIPTION = "C++ wrappers for SIMD intrinsics and parallelized, optimized mathematical functions (SSE, AVX, AVX512, NEON, SVE)"
HOMEPAGE = "https://github.com/xtensor-stack/xsimd"
LICENSE = "BSD-3-Clause"

inherit cmake

#PR = "r1"

LIC_FILES_CHKSUM = "file://LICENSE;md5=88b0e6c5e0cfdc34a62377d454240611"

SRC_URI = "git://github.com/xtensor-stack/xsimd.git;protocol=https;branch=7.x"

SRCREV = "b948624424c1ce297e0d7a3380a114f4c245b190"

EXTRA_OECMAKE = "-DCMAKE_POLICY_VERSION_MINIMUM=3.5"

BBCLASSEXTEND = "native nativesdk"
