# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-build-without-catkin-testing-enab.patch"

SRC_URI += "file://0001-trigger_matcher.h-fix-build-with-Boost-1.67.patch"
