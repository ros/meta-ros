DESCRIPTION = "GeographicLib is a small set of C++ classes for performing conversions between geographic, UTM, UPS, MGRS, geocentric, and local cartesian coordinates, for gravity (e.g., EGM2008), geoid height, and geomagnetic field (e.g., WMM2010) calculations, and for solving geodesic problems."
SECTION = "devel"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=beda1cf298e14fa7de56a07a83308905" 

DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/distrib/GeographicLib-${PV}.tar.gz"
SRC_URI[md5sum] = "e99153cf41bf64998cc4f91c00aea167"
SRC_URI[sha256sum] = "7203d56123b6f6fb31842295d57b2418f79fb0db9a06f2f65ee9e415c6f0cb70"

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

SRC_URI += "file://0001-Fix-build-with-gcc-11.patch"
