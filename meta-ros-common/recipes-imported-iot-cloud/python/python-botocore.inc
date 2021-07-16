DESCRIPTION = "Low-level, data-driven core of boto 3."
HOMEPAGE = "https://github.com/boto/botocore"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI[md5sum] = "c7cb165153055aa16168dd3700adb032"
SRC_URI[sha256sum] = "ee55ce128056c5120680d25c8e8dfa3a08dbe7ac3445dc16997daaa68ae4060e"

inherit pypi

FILESEXTRAPATHS:prepend := "${THISDIR}/python-botocore:"

SRC_URI += "\
    file://Allow-python-dateutil-2.8.1.patch \
"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-jmespath \
    ${PYTHON_PN}-dateutil \
    ${PYTHON_PN}-docutils \
    ${PYTHON_PN}-shell \
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-email \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-numbers \
    ${PYTHON_PN}-html \
    ${PYTHON_PN}-urllib3 \
    ${PYTHON_PN}-logging \
"
