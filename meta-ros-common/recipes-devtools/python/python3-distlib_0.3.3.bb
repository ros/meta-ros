SUMMARY = "Distribution utilities"
HOMEPAGE = "https://bitbucket.org/pypa/distlib"
LICENSE = "PSF"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f6a11430d5cd6e2cd3832ee94f22ddfc"

PYPI_PACKAGE = "distlib"
PYPI_PACKAGE_EXT = "zip"

SRC_URI[md5sum] = "442dc114d7e59deec1c727b8a27d7e7c"
SRC_URI[sha256sum] = "d982d0751ff6eaaab5e2ec8e691d949ee80eddf01a62eaa96ddb11531fe16b05"

inherit pypi setuptools3

BBCLASSEXTEND = "native nativesdk"
