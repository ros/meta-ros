# Copyright (c) 2023 Wind River Systems, Inc.

DEPENDS += "kortex-api"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-system-kortex-api.patch"

EXTRA_OECMAKE += "-DKORTEX_API_LIBRARY=${STAGING_LIBDIR}/libKortexApiCpp.a"
