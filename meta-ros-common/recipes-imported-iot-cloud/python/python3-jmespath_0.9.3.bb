inherit pypi setuptools3 update-alternatives
require python-jmespath.inc

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-stringold \
"

ALTERNATIVE:${PN} = "jmespath"
ALTERNATIVE_LINK_NAME[jmespath] = "${bindir}/jp.py"
ALTERNATIVE_PRIORITY = "30"
