# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-Update-Catch-to-version-v2.11.3.patch \
    file://0002-Update-Catch-to-version-v2.13.1.patch \
    file://0003-Update-Catch-to-version-v2.13.7.patch \
"
