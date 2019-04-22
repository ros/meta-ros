# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/nav2-amcl:"

SRC_URI += " \
    file://0001-Fix-build-with-catching-polymorphic-type-error.patch \
"
