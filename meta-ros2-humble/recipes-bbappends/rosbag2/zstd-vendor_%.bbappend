# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
# SRC_URI += "file://0001-CMakeLists.txt-prevent-building-zstd-with-ExternalPr.patch"

# inherit pkgconfig

INSANE_SKIP += "pkgconfig"

do_install:append() {
    rm -r ${D}${libdir}/*${SOLIBSDEV}
}
