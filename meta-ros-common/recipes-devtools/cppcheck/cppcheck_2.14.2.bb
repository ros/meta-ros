LICENSE = "0BSD & BSD-2-Clause & GPL-3.0-only & Zlib"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
                    file://externals/picojson/LICENSE;md5=29d6d693711f69885bbfe08072624f2e \
                    file://externals/simplecpp/LICENSE;md5=df43620d67c1dceec49343b0b17c385d \
                    file://externals/tinyxml2/LICENSE;md5=135624eef03e1f1101b9ba9ac9b5fffd \
                    file://win_installer/GPLv3.txt;md5=0e118ca5f3fa18e200a0f493ad21a18e"

SRC_URI = "git://github.com/danmar/cppcheck.git;protocol=https;branch=2.14.x \
           file://0001-makefile.patch \
           file://0002-pkgconfig-instaed-of-pcre-config.patch \
"

SRCREV = "fc2210afa95a4cea1afba01d5390d13d6d8d75c8"


DEPENDS = "libpcre boost"

inherit cmake pkgconfig python3native

EXTRA_OECMAKE = " \
    -DDISABLE_DMAKE=ON \
    -DBUILD_CLI=ON \
    -DBUILD_GUI=OFF \
    -DBUILD_TESTS=ON \
    -DHAVE_RULES=yes \
    -DUSE_BUNDLED_TINYXML2=ON \
    -DUSE_BOOST=ON \
"

FILES:${PN} += "${datadir}/Cppcheck"

BBCLASSEXTEND = "native nativesdk"
