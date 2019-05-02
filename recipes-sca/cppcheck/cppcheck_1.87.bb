require cppcheck.inc

SRC_URI = " https://github.com/danmar/cppcheck/archive/${PV}.tar.gz \
            file://0001-makefile.patch \
            file://0002-pkgconfig-instaed-of-pcre-config.patch \
            file://cppcheck.sca.description"
SRC_URI[md5sum] = "eba3b8b4d69045bd24104c2d0cc0cb0c"
SRC_URI[sha256sum] = "ea7ac1cd2f5c00ecffd596fd0f7281cba44308e565a634fae02b77ecd927c153"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"
