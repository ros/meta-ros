DESCRIPTION = "flake8 is a python tool that glues together pycodestyle, pyflakes, mccabe, and third-party plugins to check the style and quality of some python code."
SUMMARY = "the modular source code checker: pep8 pyflakes and co"
HOMEPAGE = "https://github.com/pycqa/flake8"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75b26781f1adf1aa310bda6098937878"

SRC_URI[sha256sum] = "fe044858146b9fc69b551a4b490d69cf960fcb78ad1edcb84e7fbb1b4a8e3872"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-core python3-json python3-logging python3-multiprocessing python3-pickle python3-pyflakes python3-unittest"

PYPI_PACKAGE = "flake8"

BBCLASSEXTEND = "native nativesdk"
