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

# QA Issue: File '/usr/lib/python/site-packages/rmf_adapter.cpython-311-x86_64-linux-gnu.so' from rmf-fleet-adapter-python was already stripped, this will prevent future debugging! [already-stripped]
INSANE_SKIP:${PN} += "already-stripped"
