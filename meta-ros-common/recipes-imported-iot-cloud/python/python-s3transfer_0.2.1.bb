inherit setuptools
require python-s3transfer.inc

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-futures \
"
