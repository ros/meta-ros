FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-Cleaning-up-build-warnings-related-to-durations-para.patch \
"