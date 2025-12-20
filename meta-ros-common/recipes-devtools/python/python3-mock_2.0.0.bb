SUMMARY = "A Python Mocking and Patching Library for Testing"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=de9dfbf780446b18aab11f00baaf5b7e"

SRC_URI[sha256sum] = "b158b6df76edd239b8208d481dc46b6afd45a846b7812ff0ce58971cf5bc8bba"

inherit pypi setuptools3

DEPENDS += " \
    python3-pbr-native"

# XXX If ever need to make work for Python 2, will need to add python-funcsigs to this list:
RDEPENDS:${PN} += " \
    python3-prettytable \
    python3-cmd2 \
    python3-pyparsing \
    python3-mccabe \
    python3-pep8 \
    python3-pyflakes \
    python3-pbr \
"
