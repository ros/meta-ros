# Copyright (c) 2020-2021 LG Electronics, Inc.

DEPENDS += "${PN}-upstream"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Use-libphidget22-from-libphidget22-upstream-and-norm.patch"
