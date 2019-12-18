inherit setuptools3
require python-s3transfer.inc

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-multiprocessing \
"
