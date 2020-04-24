# Imported as-is from
# https://github.com/labgrid-project/meta-labgrid/commit/db27f76b40bb4f25ddd69ab3421c1d92e996868e

DESCRIPTION = "python bindings for the lz4 compression library by Yann Collet"
HOMEPAGE = "https://github.com/python-lz4/python-lz4"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6231efa4dd4811e62407314d90a57573"

DEPENDS += "${PYTHON_PN}-setuptools-scm-native"

inherit pypi
