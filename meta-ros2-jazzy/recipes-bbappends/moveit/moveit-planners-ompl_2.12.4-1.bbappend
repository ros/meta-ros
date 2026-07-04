# Copyright (c) 2023-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-boost-system.patch"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-planners-ompl contains symlink .so '/usr/lib/libmoveit_ompl_interface.so'
# non -dev/-dbg/nativesdk- package moveit-planners-ompl contains symlink .so '/usr/lib/libmoveit_ompl_planner_plugin.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libmoveit_ompl_interface.so \
    ${libdir}/libmoveit_ompl_planner_plugin.so \
"
