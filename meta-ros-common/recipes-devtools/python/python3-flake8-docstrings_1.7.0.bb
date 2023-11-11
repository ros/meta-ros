DESCRIPTION = "Integration of pydocstyle and flake8 for combined linting and reporting"
HOMEPAGE = "https://github.com/pycqa/flake8-docstrings"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2c840f7b61be736d3ec8ac616fc029c9"

PYPI_PACKAGE = "flake8_docstrings"
SRC_URI[sha256sum] = "4c8cc748dc16e6869728699e5d0d685da9a10b0ea718e090b1ba088e67a941af"

inherit pypi

BBCLASSEXTEND = "native"
