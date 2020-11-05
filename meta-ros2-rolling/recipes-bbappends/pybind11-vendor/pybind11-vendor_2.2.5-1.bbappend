# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "python3-pybind11"
RDEPENDS_${PN} += "python3-pybind11"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-rolling-pybind11-vendor-don-t-build-pybind11-use-pla.patch"

# nothing to install here
do_install() {
}
