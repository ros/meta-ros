SUMMARY = "Dictionary with auto-expiring values for caching purposes"
HOMEPAGE = "https://www.mailgun.com/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=449d0a24f447991e98511a62c1b80b32"

SRC_URI[sha256sum] = "300fb92a7e98f15b05cf9a856c1415b3bc4f2e132be07daa326da6414c23ee09"

inherit pypi setuptools3

# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "python-version-smaller-3-dot-5 tests"
PACKAGECONFIG[python-version-smaller-3-dot-5] = ",,,python3-typing"
PACKAGECONFIG[tests] = ",,,python3-coverage python3-coveralls python3-dill python3-mock python3-nose"


RDEPENDS:${PN} += "python3-core"

PYPI_PACKAGE = "expiringdict"
