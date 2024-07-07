SUMMARY = "ZZipLib - libZ-based ZIP-access Library with an Easy-to-Use API"
LICENSE = "LGPL-2.0-only & MPL-1.1 & Zlib"
LIC_FILES_CHKSUM = "file://COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://docs/COPYING.LIB;md5=55ca817ccb7d5b5b66355690e9abc605 \
                    file://docs/COPYING.MPL;md5=48ff35a6e75247e702019cddd0eacc21 \
                    file://docs/COPYING.ZLIB;md5=391a94bf6bcc911c019db84f178be0d4"

SRC_URI = "git://github.com/gdraheim/zziplib;protocol=https;branch=master"

PV = "0.13.74+git"
SRCREV = "df9e9c06634cb0c48bdc42efe9f7ac55847503a5"

S = "${WORKDIR}/git"

DEPENDS = "zlib libsdl2"

inherit cmake pkgconfig python3native

EXTRA_OECMAKE = "-DZZIPTEST=OFF"
