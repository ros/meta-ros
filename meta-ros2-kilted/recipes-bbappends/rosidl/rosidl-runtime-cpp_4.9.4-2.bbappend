FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "\
    file://0001-Add-missing-cstdint-include-864.patch \
    file://0002-std-u16string-and-Unicode-characters-across-C-standa.patch \
"
