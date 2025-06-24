# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

LICENSE = "BSD-3-Clause"

SRC_URI:append = " file://0001-fix-missing-header-216.patch"

inherit ros_insane_dev_so
