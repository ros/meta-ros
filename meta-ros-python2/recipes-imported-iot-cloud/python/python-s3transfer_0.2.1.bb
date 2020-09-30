require recipes-imported-iot-cloud/python/python-s3transfer.inc

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-futures \
"
