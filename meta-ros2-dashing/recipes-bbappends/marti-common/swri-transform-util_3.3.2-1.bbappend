# Copyright (c) 2020 LG Electronics, Inc.

# Fails with boost-1.69.0
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-utm_util.h-don-t-make-UtmData-private.patch"

# Needed for proj-6
CXXFLAGS += "-DACCEPT_USE_OF_DEPRECATED_PROJ_API_H"
