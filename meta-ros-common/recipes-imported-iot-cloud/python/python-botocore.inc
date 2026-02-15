DESCRIPTION = "Low-level, data-driven core of boto 3."
HOMEPAGE = "https://github.com/boto/botocore"
AUTHOR = "Amazon Web Services"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI[sha256sum] = "ee55ce128056c5120680d25c8e8dfa3a08dbe7ac3445dc16997daaa68ae4060e"

inherit pypi

FILESEXTRAPATHS:prepend := "${THISDIR}/python-botocore:"

SRC_URI += "\
    file://Allow-python-dateutil-2.8.1.patch \
"

RDEPENDS:${PN} = "\
    python3-jmespath \
    python3-dateutil \
    python3-docutils \
    python3-shell \
    python3-netserver \
    python3-email \
    python3-json \
    python3-numbers \
    python3-html \
    python3-urllib3 \
    python3-logging \
"
