# Copyright (c) 2023-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://remove-boost-system.patch \
            file://add-bullet-dependency.patch \
            file://use-cmake-targets.patch"

do_install:append() {
    # Fix for QA warning [buildpaths]
    # Remove ${RECIPE_SYSROOT}/usr/include added by the Boost components
    sed -i -e "s#${RECIPE_SYSROOT}${includedir};##g" ${D}${ros_datadir}/moveit_planners_ompl/cmake/moveit_planners_omplTargetsExport.cmake
    # Remove ${RECIPE_SYSROOT}/opt/ros/<DISTRO>/include added by ompl
    sed -i -e "s#${RECIPE_SYSROOT}${ros_includedir}/ompl-[^;]*;##g" ${D}${ros_datadir}/moveit_planners_ompl/cmake/moveit_planners_omplTargetsExport.cmake
}

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-planners-ompl contains symlink .so '/usr/lib/libmoveit_ompl_interface.so'
# non -dev/-dbg/nativesdk- package moveit-planners-ompl contains symlink .so '/usr/lib/libmoveit_ompl_planner_plugin.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libmoveit_ompl_interface.so \
    ${libdir}/libmoveit_ompl_planner_plugin.so \
"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-planners-ompl contains symlink .so '/usr/lib/libmoveit_ompl_interface.so'
# non -dev/-dbg/nativesdk- package moveit-planners-ompl contains symlink .so '/usr/lib/libmoveit_ompl_planner_plugin.so' [dev-so]
inherit ros_insane_dev_so
