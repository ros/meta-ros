# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-hebi-CMakeLists.txt-fix-configure-with-empty-CMAKE_L.patch"

# Supports only 4 values [i686, x86_64, armhf, aarch64], otherwise it ends with default x86_64
# e.g. when CMAKE_LIBRARY_ARCHITECTURE is empty like in our builds
EXTRA_OECMAKE_append_x86 = "-DLIBHEBI_TARGET_ARCHITECTURE=i686"
EXTRA_OECMAKE_append_x86-64 = "-DLIBHEBI_TARGET_ARCHITECTURE=x86_64"
EXTRA_OECMAKE_append_arm = "-DLIBHEBI_TARGET_ARCHITECTURE=armhf"
EXTRA_OECMAKE_append_aarch64 = "-DLIBHEBI_TARGET_ARCHITECTURE=aarch64"
