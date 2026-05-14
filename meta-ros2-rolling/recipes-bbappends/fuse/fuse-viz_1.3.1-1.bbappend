# Copyright (c) 2024 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LICENSE = "BSD-3-Clause"

SRC_URI:append = " \
    file://support_qt6.patch \
"

inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}
