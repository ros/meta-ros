# Copyright (c) 2026 Wind River Systems, Inc.

LICENSE = "Apache-2.0"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-boost-system.patch \
            file://0001-refactor-migrate-from-deprecated-boost-asio-io_servi.patch \
            file://include-boost-headers.patch"

do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/cmake/sick_safetyscanners_base/sick_safetyscanners_baseTargets.cmake
}
