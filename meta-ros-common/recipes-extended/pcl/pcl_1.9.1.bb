# Copyright (c) 2021 LG Electronics, Inc.

require pcl.inc

PV = "1.9.1+git${SRCPV}"
SRCREV = "72f41b60a539cd1da67d1329b57222290122a0bb"

SRC_URI += "file://0001-Fix-deprecated-boost-endians.patch \
    file://0002-Fix-Eigen-bug-in-frustum-culling-2786.patch \
    file://0003-Removed-throw-specifier-deprecated-in-C-11.patch \
"
