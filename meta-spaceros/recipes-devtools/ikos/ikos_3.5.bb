LICENSE = "NASA-1.3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8e59a2e7eca93bf552009706554bb526"

SRC_URI = "git://github.com/NASA-SW-VnV/ikos.git;protocol=https;branch=master \
           file://use-pkgconfig.patch \
           file://allow-newer-llvm.patch \
           file://hardcode-ppl-version.patch"

PV = "3.5"
SRCREV = "1d98c65d282554ffb6997dba67b0f8e41e22e169"

S = "${WORKDIR}/git"

# NOTE: unable to map the following CMake package dependencies: GMP FrontendLLVM Doxygen LLVM Clang APRON Core SQLite3 TBB AR
DEPENDS = "\
    apron\
    boost\
    gmp\
    clang-native\
    doxygen-native\
    graphviz-native\
    mpfr\
    sqlite3\
    tbb\
"

inherit cmake python3native pkgconfig

EXTRA_OECMAKE += "-DAPRON_ROOT=${RECIPE_SYSROOT}${libdir}"

BBCLASSEXTEND = "native nativesdk"
