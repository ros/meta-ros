include python-pyproj.inc

inherit setuptools3

SRC_URI += "file://0001-python-3.9-compatibility.patch \
    file://0002-python-3.10-compatibility.patch \
"
