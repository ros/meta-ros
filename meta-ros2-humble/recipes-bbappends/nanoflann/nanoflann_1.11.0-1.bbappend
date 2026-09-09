inherit pkgconfig

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://disable-compiler-options.patch"

DEPENDS += "libeigen googletest"

EXTRA_OECMAKE = " \
    -DNANOFLANN_BUILD_EXAMPLES=OFF \
    -DNANOFLANN_USE_SYSTEM_GTEST=ON \
"
