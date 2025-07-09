# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause & MIT & Apache-2.0 & MPL-2.0 & GPL-3.0-or-later & LGPL-2.1-or-later"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://do-not-search-source-tree-for-dataset.patch"

EXTRA_OECMAKE += " -DGTSAM_USE_SYSTEM_EIGEN=ON"

# ERROR: QA Issue: File /opt/ros/rolling/lib/cmake/GTSAM_UNSTABLE/GTSAM_UNSTABLEConfig.cmake in package gtsam contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/rolling/lib/cmake/GTSAM/GTSAM-exports.cmake in package gtsam contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/rolling/lib/cmake/GTSAM/GTSAMConfig.cmake in package gtsam contains reference to TMPDIR [buildpaths]
# ERROR: QA Issue: File /opt/ros/rolling/include/gtsam/config.h in package gtsam-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${S}##g" ${D}${ros_libdir}/cmake/GTSAM_UNSTABLE/GTSAM_UNSTABLEConfig.cmake
    sed -i -e "s#${S}##g" ${D}${ros_libdir}/cmake/GTSAM/GTSAMConfig.cmake
    sed -i -e "s#${S}##g" ${D}${ros_includedir}/gtsam/config.h
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_libdir}/cmake/GTSAM/GTSAM-exports.cmake
}

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package gtsam contains symlink .so '/opt/ros/rolling/lib/libgtsam.so'
# non -dev/-dbg/nativesdk- package gtsam contains symlink .so '/opt/ros/rolling/lib/libgtsam_unstable.so' [dev-so]
FILES:${PN}-dev =+ "${ros_libdir}/libgtsam*${SOLIBSDEV}"

BBCLASSEXTEND = "native"
