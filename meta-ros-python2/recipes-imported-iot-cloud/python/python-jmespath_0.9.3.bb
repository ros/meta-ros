require recipes-imported-iot-cloud/python/python-jmespath.inc
inherit pypi update-alternatives

inherit ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-python2", "setuptools", "", d)}

python() {
    if 'meta-python2' not in d.getVar('BBFILE_COLLECTIONS').split():
        raise bb.parse.SkipRecipe('Requires meta-python2 to be present.')
}

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-argparse \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-lang \
"

ALTERNATIVE_${PN} = "jmespath"
ALTERNATIVE_LINK_NAME[jmespath] = "${bindir}/jp.py"
ALTERNATIVE_PRIORITY = "20"
