SUMMARY = "Typing stubs for PyYAML"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ec038232ab86edd7354b091c54e190e2"

SRC_URI[sha256sum] = "259f1d93079d335730a9db7cff2bcaf65d7e04b4a56b5927d49a612199b59413"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-core"

PYPI_PACKAGE = "types_pyyaml"

SRC_URI += "file://remove-license-files.patch"
