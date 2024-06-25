# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://fix-cmakefile-ament-export.patch"
