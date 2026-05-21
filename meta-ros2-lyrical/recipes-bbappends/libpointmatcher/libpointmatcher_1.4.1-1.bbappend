# Copyright (c) 2022 Wind River Systems, Inc.

# CMake Error at CMakeLists.txt:40 (MESSAGE):
#   32 bits compiler detected.  Libpointmatcher is only supported in 64 bits.
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://replace-deprecated-boost-functions.patch"

# ERROR: libpointmatcher-1.4.1-1-r0 do_package_qa: QA Issue: File /opt/ros/rolling/lib/cmake/pointmatcher/libpointmatcherConfig.cmake in package libpointmatcher contains reference to TMPDIR [buildpaths]
# ERROR: libpointmatcher-1.4.1-1-r0 do_package_qa: QA Issue: File /opt/ros/rolling/share/libpointmatcher/cmake/libpointmatcher-config.cmake in package libpointmatcher-dev contains reference to TMPDIR [buildpaths]
# ERROR: libpointmatcher-1.4.1-1-r0 do_package_qa: QA Issue: File /opt/ros/rolling/share/libpointmatcher/cmake/libpointmatcherConfig.cmake in package libpointmatcher-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}${prefix}#$\{CMAKE_PREFIX_PATH\}#g" ${D}${ros_libdir}/cmake/pointmatcher/libpointmatcherConfig.cmake
    sed -i -e "s#${RECIPE_SYSROOT}${prefix}#$\{CMAKE_PREFIX_PATH\}#g" ${D}${ros_datadir}/libpointmatcher/cmake/libpointmatcher-config.cmake
    sed -i -e "s#${RECIPE_SYSROOT}${prefix}#$\{CMAKE_PREFIX_PATH\}#g" ${D}${ros_datadir}/libpointmatcher/cmake/libpointmatcherConfig.cmake
}

BBCLASSEXTEND = "native"
