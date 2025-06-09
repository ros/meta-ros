FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LICENSE = "BSD-3-Clause"

SRC_URI:append = " file://0001-Adding-the-include-of-cstdint.patch"
