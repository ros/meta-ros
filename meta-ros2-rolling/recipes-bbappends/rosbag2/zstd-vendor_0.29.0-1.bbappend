FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-CMakeLists.txt-prevent-building-zstd-with-ExternalPr.patch"

inherit pkgconfig

LICENSE = "Apache-2.0"

