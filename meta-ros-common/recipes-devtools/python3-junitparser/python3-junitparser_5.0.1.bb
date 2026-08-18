SUMMARY = "Parses JUnit/xUnit Result XML files with ease"
HOMEPAGE = "https://junitparser.readthedocs.io"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=97e3403c3e32001abc4f414aefc752b7"

SRC_URI = "\
    git://github.com/weiwei/junitparser;protocol=https;branch=master \
    file://0001-ptest-remove-the-src.-package.patch \
    file://0002-ptest-Locale-en_US-de_DE-are-not-default-installed-i.patch \
    file://0003-Update-uv-build-requirement-from-0.12.0-0.11.7-to-0..patch \
"

SRCREV = "d98bdb70fbde4d08e191df17bd51576102c19d6a"

inherit python_uv_build ptest-python-pytest
