FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-Revert-install-of-.so-files-into-python-path.patch \
"

