SUMMARY = "This is a python implementation of the MAVLink protocol."
HOMEPAGE = "https://github.com/ArduPilot/pymavlink/"

LICENSE = "LGPL-3.0-only"
LIC_FILES_CHKSUM = "file://README.md;md5=203be5c2bd6638cbb07938f9cb7ec45e"

SRC_URI[sha256sum] = "7bf45ad4a250e5e9928c33b5ff56afed4dbc6f99c8f58d05051e2a308150db80"

inherit setuptools3 pypi

BBCLASSEXTEND = "native nativesdk"

DEPENDS = "python3-pip-native python3-wheel-native"
RDEPENDS:${PN} = "${PYTHON_PN}-future ${PYTHON_PN}-lxml"
