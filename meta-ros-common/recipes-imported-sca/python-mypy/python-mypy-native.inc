DESCRIPTION = "Optional static typing for Python 3 and 2 (PEP 484)"
HOMEPAGE = "https://github.com/python/mypy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8d438618dacdddfdf08836bfe5e4b8a7"

DEPENDS += " \
            ${PYTHON_PN}-mypy-extensions-native \
            ${PYTHON_PN}-typed-ast-native \
            ${PYTHON_PN}-typing-extensions-native \
            "

PYPI_PACKAGE = "mypy"

inherit pypi
inherit sca-sanity

FILES_${PN} += "${datadir}"
SRC_URI += "file://mypy.sca.description \
            file://mypy.sca.score"

inherit native

do_install_append() {
    install -d ${D}${datadir}
    install ${WORKDIR}/mypy.sca.description ${D}${datadir}
    install ${WORKDIR}/mypy.sca.score ${D}${datadir}
}
