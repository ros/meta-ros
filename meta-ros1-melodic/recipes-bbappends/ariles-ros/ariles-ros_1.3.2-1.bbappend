# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-bridges-ros-drop-roscpp-dependency.patch"

FILES:${PN} += " \
    ${datadir}/ariles-array \
    ${datadir}/ariles-core \
    ${datadir}/ariles-octave \
    ${datadir}/ariles-yaml-cpp \
"

inherit pkgconfig
