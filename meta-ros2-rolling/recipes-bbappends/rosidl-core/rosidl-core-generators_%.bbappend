FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-Add-python-imports-to-rosidl_core_generators-extras.patch \
"
