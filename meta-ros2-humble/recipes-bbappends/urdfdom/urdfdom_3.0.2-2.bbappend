# Copyright (c) 2025 Wind River Systems, Inc

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://use-tinyxml-by-name.patch"

# QA Issue: File /opt/ros/humble/lib/urdfdom/cmake/urdfdomExport.cmake in package urdfdom contains reference to TMPDIR [buildpaths]
# QA Issue: File /opt/ros/humble/lib/urdfdom/cmake/urdfdom-config.cmake in package urdfdom contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/lib/urdfdom/cmake/urdfdomExport.cmake
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${ros_prefix}/lib/urdfdom/cmake/urdfdom-config.cmake
}
