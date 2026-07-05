# Copyright (c) 2023-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://add-bullet-dependency.patch"
 
ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

do_install:append() {
    # Fix for QA warning [buildpaths]
    sed -i -e "s#${RECIPE_SYSROOT}${includedir}#${includedir}#g" ${D}${ros_datadir}/pilz_industrial_motion_planner/cmake/pilz_industrial_motion_plannerTargetsExport.cmake
}
