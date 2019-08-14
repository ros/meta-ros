# Copyright (c) 2019 LG Electronics, Inc.

# What's in package.xml doesn't match what's in the source files.
# https://github.com/SteveMacenski/navigation2-release/issues/1
# In dashing BSD-3-Clause headers were changed to Apache-2
LICENSE = "LGPL-2.1 & BSD-3-Clause"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://0001-Fix-build-with-catching-polymorphic-type-error.patch \
"
