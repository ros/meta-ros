# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += " \
    ament-cmake-gen-version-h \
    ament-package-native \
    python3-catkin-pkg-native \
"

FILES:${PN} += "${libdir}/python"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists-search-for-Python3-Development.patch"

# Could NOT find PkgConfig (missing: PKG_CONFIG_EXECUTABLE)
inherit pkgconfig
