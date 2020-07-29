# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-search-for-boost_python37-instead-of-.patch"

# Fails with webOS OSE which by default uses -Werror=return-type
# tuw-geometry/0.0.3-r0/git/src/tuw_geometry/linesegment2d.cpp:119:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"

FILES_${PN} += "${ros_libdir}/tuw_geometry_wrapper.so"
