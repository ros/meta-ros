# Copyright (c) 2025 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

export PYTHON_DIR

SRC_URI:append = " \
    file://0001-use-system-pykdl.patch \
"
