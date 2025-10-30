# Copyright (c) 2025 Wind River Systems, Inc.
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a15308b1b874351f35c19852e44c66fd"

SRC_URI = "git://github.com/ros2/Mimick.git;protocol=https;branch=ros2 \
           file://0002-add-riscv64-support-and-add-float-double-tests.patch"

PV = "0.3.0"
SRCREV = "1e138b0e13da99278453dc96af954890d9f48348"

S = "${WORKDIR}/git"

inherit cmake

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE = ""


# Copyright (c) 2020-2021 LG Electronics, Inc.
# mimick-vendor/0.2.2-1-r0/recipe-sysroot/usr/include/features.h:397:4: error: #warning _FORTIFY_SOURCE requires compiling with optimization (-O) [-Werror=cpp]
lcl_maybe_fortify = ""
