SUMMARY = "eProsima FastCDR library provides two serialization mechanisms. One is the standard CDR serialization mechanism, while the other is a faster implementation of it."
HOMEPAGE = "https://github.com/eProsima/Fast-CDR"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRCREV = "8d1489780cd58947e5f7104b84641f680224cdea"
SRC_URI = "git://github.com/eProsima/Fast-CDR.git;protocol=git; \
           file://0001-don-t-use-INSTALL_INTERFACE.patch \
           "

S = "${WORKDIR}/git"

inherit cmake
