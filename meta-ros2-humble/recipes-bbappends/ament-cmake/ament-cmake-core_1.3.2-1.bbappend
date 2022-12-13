FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI:append = " \
    file://0001-python.cmake-experimental-added-COMPONENTS-Developme.patch \
"
