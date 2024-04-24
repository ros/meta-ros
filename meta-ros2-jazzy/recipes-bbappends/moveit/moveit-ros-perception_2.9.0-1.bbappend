# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_pointcloud_octomap_updater_core.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_depth_image_octomap_updater_core.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_point_containment_filter.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_pointcloud_octomap_updater.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_lazy_free_space_updater.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_mesh_filter.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_depth_image_octomap_updater.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_semantic_world.so' [dev-so]
FILES:${PN}-dev += " \
    ${libdir}/libmoveit_pointcloud_octomap_updater_core.so \
    ${libdir}/libmoveit_depth_image_octomap_updater_core.so \
    ${libdir}/libmoveit_point_containment_filter.so \
    ${libdir}/libmoveit_pointcloud_octomap_updater.so \
    ${libdir}/libmoveit_lazy_free_space_updater.so \
    ${libdir}/libmoveit_mesh_filter.so \
    ${libdir}/libmoveit_depth_image_octomap_updater.so \
    ${libdir}/libmoveit_semantic_world.so \
"
