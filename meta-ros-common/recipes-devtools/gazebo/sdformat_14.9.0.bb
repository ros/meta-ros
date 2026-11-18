# Copyright (c) 2024 Wind River Systems, Inc.
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a461be67a1edf991251f85f3aadd1d0"

SRC_URI = "git://github.com/gazebosim/sdformat.git;protocol=https;branch=sdf14"

SRCREV = "97d9b0cea4a84003022d27d8d97b1def10b778ef"


inherit cmake pkgconfig python3targetconfig

DEPENDS = " \
    gz-cmake3 \
    gz-math7 \
    gz-tools2 \
    gz-utils2 \
    libtinyxml2 \
    python3-pybind11 \
    python3-psutil-native \
    ruby-native \
"

PACKAGES =+ "python3-${PN}"

FILES:${PN} += " \
    ${libdir}/ruby/gz \
    ${datadir}/gz \
    ${datadir}/sdformat14/* \
"

FILES:${PN}-dev += " \
    ${libdir}/libsdformat14.so \
"

FILES:python3-${PN} += " \
    ${libdir}/python \
"

# urdfdom is only provided by the ROS distro layers; use the copy bundled with sdformat so
# that meta-ros-common does not depend on them.
EXTRA_OECMAKE += "-DUSE_INTERNAL_URDF=ON"
