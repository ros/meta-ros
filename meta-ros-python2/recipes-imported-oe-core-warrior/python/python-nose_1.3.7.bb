# restore python2 version removed in:
# http://git.openembedded.org/openembedded-core/commit/?h=zeus&id=9f07b2836405d86e869780f8f1ae00843eadc409

SUMMARY = "Extends Python unittest to make testing easier"
HOMEPAGE = "http://readthedocs.org/docs/nose/"
DESCRIPTION = "nose extends the test loading and running features of unittest, \
making it easier to write, find and run tests."
SECTION = "devel/python"
LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://lgpl.txt;md5=a6f89e2100d9b6cdffcea4f398e37343"

SRC_URI[md5sum] = "4d3ad0ff07b61373d2cefc89c5d0b20b"
SRC_URI[sha256sum] = "f1bffef9cbc82628f6e7d7b40d7e255aefaa1adb6a1b1d26c69a8b79e6208a98"

inherit pypi

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-unittest \
"

BBCLASSEXTEND = "native nativesdk"

do_install_append() {
    rm ${D}${bindir}/nosetests
}
