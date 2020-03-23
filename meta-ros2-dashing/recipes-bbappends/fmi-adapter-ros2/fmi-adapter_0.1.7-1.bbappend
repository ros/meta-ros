# Copyright (c) 2019-2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-standalone-fmilibrary.patch"

DEPENDS += "fmilibrary-vendor"
