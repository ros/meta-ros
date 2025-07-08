# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2025 Wind River Systems, Inc

LICENSE = "BSD-3-Clause"

inherit ros_insane_dev_so

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-tinyxml-by-name.patch \
            file://fix-missing-header.patch"

# QA Issue: File /opt/ros/humble/lib/urdfdom/cmake/urdfdomExport.cmake in package urdfdom contains reference to TMPDIR [buildpaths]
# QA Issue: File /opt/ros/humble/lib/urdfdom/cmake/urdfdom-config.cmake in package urdfdom contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/lib/urdfdom/cmake/urdfdomExport.cmake
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/lib/urdfdom/cmake/urdfdom-config.cmake
}
