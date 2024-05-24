SUMMARY = "Make your Python code clearer and more reliable by declaring Parameters."
DESCRIPTION = "Param is a library providing Parameters: Python attributes \
    extended to have features such as type and range checking, dynamically \
    generated values, documentation strings, default values, etc., each of \
    which is inherited from parent classes if not specified in a subclass."
HOMEPAGE = "https://pypi.org/project/param/"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=120197d29d1cf583abd283ef26669576"

PYPI_PACKAGE = "param"

inherit pypi setuptools3

SRC_URI[sha256sum] = "59d55048d42a85e148a69837df42bd11c3391d47fad15ba57d118e145f001ef2"

BBCLASSEXTEND = "native nativesdk"
