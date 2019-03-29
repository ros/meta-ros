SUMMARY = "Implementation of RTPS Standard."
HOMEPAGE = "https://github.com/eProsima/Fast-RTPS"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
DEPENDS = "asio libtinyxml2"

SRCREV = "bfb448e19bff253293e8f28ee8c3d3d78d882be2"
SRC_URI = "git://github.com/eProsima/Fast-RTPS.git;protocol=git; \
    file://0001-don-t-use-INSTALL_INTERFACE.patch \
    file://0001-FindTinyXML2-use-pkg-config-to-find-tinyxml2.patch \
"

S = "${WORKDIR}/git"

inherit cmake

do_install_append() {
    rm -r ${D}/usr/examples
}
