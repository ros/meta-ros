# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "\
    file://0001-setup.cfg-fix-warning.patch \
    file://0002-setup.py-install-data_files-without-share-prefix.patch \
"
