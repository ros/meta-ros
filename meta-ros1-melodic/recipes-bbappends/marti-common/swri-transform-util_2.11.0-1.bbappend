# Copyright (c) 2020 LG Electronics, Inc.

EXTRA_OECMAKE += "-Dswri_nodelet_SHARE=${RECIPE_SYSROOT}${ros_datadir}/swri_nodelet"

# Fails with boost-1.69.0
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-utm_util.h-don-t-make-UtmData-private.patch"
