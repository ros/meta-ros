# fix missing include, upstream pending
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://0001-UDPPacketMerger-fixing-missing-include.patch \
"