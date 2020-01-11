# Copyright (c) 2020 LG Electronics, Inc.

# Fails with boost-1.69.0
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-utm_util.h-don-t-make-UtmData-private.patch"
