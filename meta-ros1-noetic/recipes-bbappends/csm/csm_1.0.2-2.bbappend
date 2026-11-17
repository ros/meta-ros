# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += " \
    file://0001-sm-CMakeLists.txt-use-include_directories-macro-to-r.patch \
"

# package.xml declares "LGPL", which is not a valid license identifier.
# Upstream check: upstream LICENSE.txt is LGPL v3.
LICENSE = "LGPL-3.0-only"
