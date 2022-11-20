FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-nav2_package-remove-Werror-from-build-flags.patch \
"
