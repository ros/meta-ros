LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=998fb0b16ad8a4fb8bd41bf3faf2d21c"

SRC_URI = " \
    git://github.com/luxonis/FP16.git;protocol=https;branch=master;name=fp16 \
    git://github.com/Maratyszcza/psimd.git;protocol=https;branch=master;destsuffix=git/psimd;name=psimd \
"

SRCREV_fp16 = "c911175d2717e562976e606c6e5f799bf40cf94e"
SRCREV_psimd = "072586a71b55b7f8c584153d223e95687148a900"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE = " \
    -DFP16_BUILD_TESTS=OFF \
    -DFP16_BUILD_BENCHMARKS=OFF \
    -DPSIMD_SOURCE_DIR=${S}/psimd \
"

