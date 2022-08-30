FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-CMakeLists.txt-using-pkgconfig-for-libzstd.patch \
"
