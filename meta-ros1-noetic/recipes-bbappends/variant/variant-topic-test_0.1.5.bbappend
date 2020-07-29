# Copyright (c) 2019-2020 LG Electronics, Inc.

# Missing license version in package.xml
# https://github.com/ANYbotics/variant-release/issues/1
LICENSE = "LGPL-3.0+"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-build-without-catkin-testing-enab.patch"
