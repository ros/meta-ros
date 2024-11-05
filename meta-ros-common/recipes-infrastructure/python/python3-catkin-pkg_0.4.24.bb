require python-catkin-pkg.inc

SRC_URI += "file://0001-python_setup.py-fix-build-with-setuptools-v59.0.0-an.patch"
SRC_URI += "file://0002-package-py-remove-newline-in-description-warning.patch"

inherit setuptools3
