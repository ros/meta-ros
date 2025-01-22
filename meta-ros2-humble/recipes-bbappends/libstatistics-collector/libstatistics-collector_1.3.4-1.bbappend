# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-make-moving-average-statistics-dtor-virtual.patch \
"
