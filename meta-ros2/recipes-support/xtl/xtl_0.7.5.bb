SUMMARY = "The X template library"
HOMEPAGE = "https://xtl.readthedocs.io/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c12cbcb0f50cce3b0c58db4e3db8c2da"

DEPENDS = "nlohmann-json"

SRC_URI = "git://github.com/xtensor-stack/xtl.git;protocol=https;branch=master"

SRCREV = "fea39142693fbbc2ef19d75012bc6b46ef0a5f8c"

inherit cmake
