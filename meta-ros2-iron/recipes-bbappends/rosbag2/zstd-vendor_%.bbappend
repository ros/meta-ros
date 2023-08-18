# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
# SRC_URI += "file://0001-CMakeLists.txt-prevent-building-zstd-with-ExternalPr.patch"

# inherit pkgconfig

INSANE_SKIP += "pkgconfig"

do_install:append() {
    rm -r ${D}${libdir}/*${SOLIBSDEV}
    # ERROR: rosbag2-compression-zstd-0.15.1-2-r0 do_prepare_recipe_sysroot: The file /usr/lib/libzstd.so.1 is installed by both zstd and zstd-vendor, aborting
    rm -r ${D}${libdir}/*${SOLIBS}
    rm -r ${D}${libdir}/pkgconfig
    rm -r ${D}${libdir}
    rm -r ${D}${includedir}
}


