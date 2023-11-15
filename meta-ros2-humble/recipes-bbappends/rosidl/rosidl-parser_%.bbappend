# Copyright (c) 2023 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-fix-libdir.patch"

EXTRA_OECMAKE += " -DPYTHON_INSTALL_DIR=${baselib}/${PYTHON_DIR}/site-packages"
