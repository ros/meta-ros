# Copyright (c) 2022 Wind River Systems, Inc.

FILES:${PN} += "${libdir}/python3/dist-packages"

LICENSE = "BSD-3-Clause"

# ERROR: libnabo-1.1.1-1-r0 do_package_qa: QA Issue: File /opt/ros/rolling/share/libnabo/cmake/libnabo-targets.cmake in package libnabo-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_datadir}/libnabo/cmake/libnabo-targets.cmake
}

BBCLASSEXTEND = "native"
