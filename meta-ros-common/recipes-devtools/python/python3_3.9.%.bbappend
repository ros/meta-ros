# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Revert-Lib-sysconfig.py-use-libdir-values-from-configuratio.patch \
            file://0002-Lib-sysconfig.py-use-prefix-value-from-build-configu.patch \
            file://0003-sysconfig.py-use-platlibdir-also-for-purelib.patch"
