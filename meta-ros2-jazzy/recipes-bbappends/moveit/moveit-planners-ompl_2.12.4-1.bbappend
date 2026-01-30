# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-planners-ompl contains symlink .so '/usr/lib/libmoveit_ompl_interface.so'
# non -dev/-dbg/nativesdk- package moveit-planners-ompl contains symlink .so '/usr/lib/libmoveit_ompl_planner_plugin.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libmoveit_ompl_interface.so \
    ${libdir}/libmoveit_ompl_planner_plugin.so \
"
