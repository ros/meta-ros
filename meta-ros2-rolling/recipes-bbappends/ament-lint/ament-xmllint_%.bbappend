FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-WIP-fetch-the-schema-with-wget-and-not-with-xmllint.patch"

# xmllint
RDEPENDS:${PN} += "libxml2-utils"
