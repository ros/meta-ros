# Copyright (c) 2024 Wind River Systems, Inc.
BBCLASSEXTEND = "native nativesdk"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://Set-MATH_LIBRARY-default.patch"
