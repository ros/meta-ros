# Copyright (c) 2024 Wind River Systems, Inc.
SUMMARY = "SDFormat is an XML file format that describes environments, objects, and robots"
DESCRIPTION = "\
    SDFormat is an XML file format that describes environments, objects, \
    and robots in a manner suitable for robotic applications \
    SDFormat is capable of representing and describing different physic engines, lighting properties, \
    terrain, static or dynamic objects, and articulated robots with various sensors, and actuators. \
    The format of SDFormat is also described by XML, \
    which facilitates updates and allows conversion from previous versions. \
    "
HOMEPAGE = "https://gazebosim.org/libs/sdformat/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

DEPENDS = " \
    gz-cmake-vendor \
    gz-math-vendor \
    gz-tools-vendor \
    gz-utils-vendor \
    libtinyxml2 \
    python3-psutil-native \
    python3-pybind11 \
    ruby-native \
    urdfdom \
"

SRC_URI = "git://github.com/gazebosim/sdformat.git;protocol=https;branch=sdf15"

SRCREV = "02e30ddf750fe2eceaee7d84c46ee9dd24cf69fb"


inherit cmake pkgconfig python3targetconfig

PACKAGES =+ "python3-${PN}"

FILES:${PN} += "\
    ${libdir}/ruby/gz \
    ${datadir}/gz \
    ${datadir}/sdformat15/* \
"

FILES:python3-${PN} += "\
    ${libdir}/python \
"
