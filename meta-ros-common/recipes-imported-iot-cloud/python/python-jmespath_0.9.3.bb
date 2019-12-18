inherit pypi setuptools update-alternatives
require python-jmespath.inc

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-argparse \
    ${PYTHON_PN}-io \
    ${PYTHON_PN}-lang \
"

ALTERNATIVE_${PN} = "jmespath"
ALTERNATIVE_LINK_NAME[jmespath] = "${bindir}/jp.py"
ALTERNATIVE_PRIORITY = "20"
