# Copyright (c) 2020-2021 LG Electronics, Inc.

DEPENDS += "python3-pybind11"
RDEPENDS:${PN} += "python3-pybind11"
ALLOW_EMPTY:${PN} = "1"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-rolling-pybind11-vendor-don-t-build-pybind11-use-pla.patch"
