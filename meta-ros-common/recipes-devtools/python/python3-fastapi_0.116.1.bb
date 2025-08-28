LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=95792ff3fe8e11aa49ceb247e66e4810"

SRC_URI[sha256sum] = "ed52cbf946abfd70c5a0dccb24673f0670deeb517a88b3544d03c2a6bf283143"

inherit pypi python_setuptools_build_meta

DEPENDS += " \
    python3-pdm-native \
    python3-pdm-backend-native \
"

PYPI_PACKAGE = "fastapi"
