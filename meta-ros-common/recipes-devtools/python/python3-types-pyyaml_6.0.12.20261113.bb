SUMMARY = "Typing stubs for PyYAML"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ec038232ab86edd7354b091c54e190e2"

SRC_URI[sha256sum] = "0828be2580fd94151182364f4d0158e4de62fdbeeb8d4296f7f7d2b6c22bb640"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-core"

PYPI_PACKAGE = "types_pyyaml"

SRC_URI += "file://remove-license-files.patch"
