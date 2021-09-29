FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://no_compiler_probe.patch"

FILES:${PN}-dev += "${libdir}/libfbow.so"
