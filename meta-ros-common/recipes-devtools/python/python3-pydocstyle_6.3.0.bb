SUMMARY = "docstring style checker"
HOMEPAGE = "https://github.com/PyCQA/pydocstyle/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE-MIT;md5=e759cd67def347876897f64931fd6065"

SRC_URI = "git://github.com/PyCQA/pydocstyle.git;branch=master;protocol=https"
SRCREV = "07f6707e2c5612960347f7c00125620457f490a7"

RDEPENDS:${PN} += "python3-snowballstemmer"

inherit python_poetry_core

BBCLASSEXTEND += "native nativesdk"
