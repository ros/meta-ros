FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "file://0001-CMakeLists.txt-don-t-probe-compiler.patch"

FILES:${PN}-dev += "${libdir}/libfbow.so"
