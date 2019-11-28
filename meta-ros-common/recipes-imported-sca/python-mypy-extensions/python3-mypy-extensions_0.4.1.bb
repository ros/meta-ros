SUMMARY = "Experimental type system extensions for programs checked with the mypy typechecker."
HOMEPAGE = "http://www.mypy-lang.org/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0fe3219e2470a78c0d1837019b8b426e"

PYPI_PACKAGE = "mypy_extensions"

inherit pypi
inherit setuptools3

SRC_URI[md5sum] = "d14d945e5c54e7a61607e00fcfdbbcd5"
SRC_URI[sha256sum] = "37e0e956f41369209a3d5f34580150bcacfabaa57b33a15c0b25f4b5725e0812"

BBCLASSEXTEND = "native"
