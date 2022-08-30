DEPENDS:append = " \
    libyaml \
" 

# Added patch from upstream to detect if libyaml is already installed
# before building
# Upstream status pull request approved but not merged
FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"
SRC_URI += " \
    file://0001-check-if-libyaml-is-already-present-before-building-.patch \
"

inherit pkgconfig