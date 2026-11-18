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
    gz-cmake \
    gz-math \
    gz-tools \
    gz-utils \
    libtinyxml2 \
    python3-psutil-native \
    python3-pybind11 \
    ruby-native \
"

SRC_URI = "git://github.com/gazebosim/sdformat.git;protocol=https;branch=sdf16"

SRCREV = "9d96fcfbfe276cfd17377b4bf2c420d605c8d330"


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

# urdfdom is only provided by the ROS distro layers; use the copy bundled with sdformat so
# that meta-ros-common does not depend on them.
EXTRA_OECMAKE += "-DUSE_INTERNAL_URDF=ON"
