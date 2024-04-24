# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-hybrid-planning contains symlink .so '/usr/lib/libforward_trajectory_plugin.so'
# non -dev/-dbg/nativesdk- package moveit-hybrid-planning contains symlink .so '/usr/lib/libsingle_plan_execution_plugin.so'
# non -dev/-dbg/nativesdk- package moveit-hybrid-planning contains symlink .so '/usr/lib/libsimple_sampler_plugin.so'
# non -dev/-dbg/nativesdk- package moveit-hybrid-planning contains symlink .so '/usr/lib/libmotion_planning_pipeline_plugin.so'
# non -dev/-dbg/nativesdk- package moveit-hybrid-planning contains symlink .so '/usr/lib/libmoveit_local_planner_component.so'
# non -dev/-dbg/nativesdk- package moveit-hybrid-planning contains symlink .so '/usr/lib/libreplan_invalidated_trajectory_plugin.so'
# non -dev/-dbg/nativesdk- package moveit-hybrid-planning contains symlink .so '/usr/lib/libmoveit_hybrid_planning_manager.so'
# non -dev/-dbg/nativesdk- package moveit-hybrid-planning contains symlink .so '/usr/lib/libmoveit_global_planner_component.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libforward_trajectory_plugin.so \
    ${libdir}/libsingle_plan_execution_plugin.so \
    ${libdir}/libsimple_sampler_plugin.so \
    ${libdir}/libmotion_planning_pipeline_plugin.so \
    ${libdir}/libmoveit_local_planner_component.so \
    ${libdir}/libreplan_invalidated_trajectory_plugin.so \
    ${libdir}/libmoveit_hybrid_planning_manager.so \
    ${libdir}/libmoveit_global_planner_component.so \
"
