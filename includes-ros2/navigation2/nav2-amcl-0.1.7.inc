# Copyright (c) 2019 LG Electronics, Inc.

# What's in package.xml doesn't match what's in the source files.
LICENSE = "LGPL-2.1 & BSD-3-Clause"

FILESEXTRAPATHS_prepend := "${THISDIR}/nav2-amcl:"

SRC_URI += " \
    file://0001-Fix-build-with-catching-polymorphic-type-error.patch \
"
