inherit setuptools3
require python-s3transfer.inc

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-multiprocessing \
"
