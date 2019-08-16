# Copyright (c) 2019 LG Electronics, Inc.

SUMMARY  = "A wrapper for the Gnu Privacy Guard (GPG or GnuPG)"
HOMEPAGE = "https://bitbucket.org/vinay.sajip/python-gnupg/src/default/"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b0b7ac63b60085b23fa9f7e1951daa1d"

SRC_URI[md5sum] = "b5d98344798b3cbb80cdcc1bfd788ea3"
SRC_URI[sha256sum] = "ef47b02eaf41dee3cf4b02ddf83130827318de9fe3eae89d01a3f05859e20e1a"

DEPENDS += "gnupg"

PYPI_PACKAGE = "python-gnupg"

inherit pypi
