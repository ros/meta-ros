SUMMARY = "Provides a mocker fixture"
HOMEPAGE = "https://github.com/pytest-dev/pytest-mock/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=9;md5=2a11afb59dbbc9a479b23de83ab930a6 \
    file://LICENSE;md5=b2ddb1e69238461b7e4ef2a84d874109 \
"

SRC_URI[md5sum] = "4cb5de612352f0eb0d3e1bc656f82843"
SRC_URI[sha256sum] = "636e792f7dd9e2c80657e174c04bf7aa92672350090736d82e97e92ce8f68737"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

inherit pypi setuptools3
