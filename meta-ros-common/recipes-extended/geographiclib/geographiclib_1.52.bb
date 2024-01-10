DESCRIPTION = "GeographicLib is a small set of C++ classes for performing conversions between geographic, UTM, UPS, MGRS, geocentric, and local cartesian coordinates, for gravity (e.g., EGM2008), geoid height, and geomagnetic field (e.g., WMM2010) calculations, and for solving geodesic problems."
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ee38ad8ee674cd54d8abbc31bf5a58ff" 

DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/distrib/GeographicLib-${PV}.tar.gz"
SRC_URI[md5sum] = "52407e8380335957377c6ac6118ce6e3"
SRC_URI[sha256sum] = "5d4145cd16ebf51a2ff97c9244330a340787d131165cfd150e4b2840c0e8ac2b"

S = "${WORKDIR}/GeographicLib-${PV}"

PACKAGE_BEFORE_PN += "${PN}-tools"

FILES:${PN}-tools = " \
    ${bindir} \
    ${sbindir} \
"

PACKAGES += "${PN}-matlab ${PN}-node ${PN}-python"
FILES:${PN}-matlab = "${datadir}/matlab"
FILES:${PN}-node = "${libdir}/node_modules"
FILES:${PN}-python = "${libdir}/python"

inherit cmake

# enable both shared and static libraries (static is required by robot-localization-2.6.9-1 in melodic)
# Ensure geographiclib is configured to the proper folder to look for data files.
EXTRA_OECMAKE += "-DGEOGRAPHICLIB_LIB_TYPE=BOTH -DGEOGRAPHICLIB_DATA=/usr/share/GeographicLib"

# stage bindir to keep CMake happy
# | -- Reading /jenkins/mjansa/build/ros/webos-melodic-hardknott/tmp-glibc/work/qemux86-webos-linux/robot-localization/2.6.9-1-r0/recipe-sysroot/usr/lib/cmake/GeographicLib/geographiclib-config.cmake
# | -- GeographicLib configuration, version 1.48
# | CMake Error at /jenkins/mjansa/build/ros/webos-melodic-hardknott/tmp-glibc/work/qemux86-webos-linux/robot-localization/2.6.9-1-r0/recipe-sysroot/usr/lib/cmake/GeographicLib/geographiclib-targets.cmake:123 (message):
# |   The imported target "CartConvert" references the file
# |
# |      "/jenkins/mjansa/build/ros/webos-melodic-hardknott/tmp-glibc/work/qemux86-webos-linux/robot-localization/2.6.9-1-r0/recipe-sysroot/usr/bin/CartConvert"
# |
# |   but this file does not exist.  Possible reasons include:
# OE doesn't stage ${bindir} for target recipes, but in this case the CartConvert isn't
# being called during the cross-build, so we can include it just to keep CMake happy
sysroot_stage_all:append() {
    sysroot_stage_dir ${D}${bindir} ${SYSROOT_DESTDIR}${bindir}
}
