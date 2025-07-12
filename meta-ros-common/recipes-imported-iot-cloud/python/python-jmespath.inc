SUMMARY = "JSON Matching Expressions"
AUTHOR = "James Saryerwinnie"
HOMEPAGE = "https://github.com/jmespath/jmespath.py"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2683790f5fabb41a3f75b70558799eb4"

PR = "r0"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-math \
    ${PYTHON_PN}-pprint \
"

SRC_URI[sha256sum] = "6a81d4c9aa62caf061cb517b4d9ad1dd300374cd4706997aff9cd6aedd61fc64"
