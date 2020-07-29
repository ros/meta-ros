# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-bridges-ros-drop-roscpp-dependency.patch"

FILES_${PN} += " \
    ${datadir}/ariles-array \
    ${datadir}/ariles-core \
    ${datadir}/ariles-octave \
    ${datadir}/ariles-yaml-cpp \
"
