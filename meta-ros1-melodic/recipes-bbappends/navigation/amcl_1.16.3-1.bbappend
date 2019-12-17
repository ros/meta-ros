# Copyright (c) 2019 LG Electronics, Inc.

# Missing license version in package.xml maps it to invalid LGPL-2
LICENSE = "LGPL-2.1+"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-add-missing-includes.patch"
