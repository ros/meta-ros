# Copyright (c) 2019 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-cmake-remove-boost-signals-search-as-it-is-removed-s.patch \
"
