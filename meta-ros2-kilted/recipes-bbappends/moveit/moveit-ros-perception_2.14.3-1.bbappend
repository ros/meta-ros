# Copyright (c) 2023-2026 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://remove-ament-target-dependencies.patch \
            file://add-bullet-dependency.patch"

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_pointcloud_octomap_updater_core.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_depth_image_octomap_updater_core.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_point_containment_filter.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_pointcloud_octomap_updater.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_lazy_free_space_updater.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_mesh_filter.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_depth_image_octomap_updater.so'
# non -dev/-dbg/nativesdk- package moveit-ros-perception contains symlink .so '/usr/lib/libmoveit_semantic_world.so' [dev-so]
inherit ros_insane_dev_so

# Needed for compatibility on devices like the Raspberry Pi which use OpenGL ES
# CMake Error at ../moveit-ros-perception/2.14.3-1/recipe-sysroot-native/usr/share/cmake-4.3/Modules/FindPackageHandleStandardArgs.cmake:290 (message):
#   Could NOT find GLUT (missing: GLUT_glut_LIBRARY)
do_configure:prepend() {
    if [ -e ${STAGING_LIBDIR}/libfreeglut-gles.so ] && [ ! -e ${STAGING_LIBDIR}/libglut.so ]; then
        # Ensure the library exists as libglut.so so CMake's FindGLUT finds it
        ln -sf ${STAGING_LIBDIR}/libfreeglut-gles.so ${STAGING_LIBDIR}/libglut.so
    fi
}

do_install:append() {
    # Fix for QA warning [buildpaths] for libGL and libGLU
    sed -i -e "s#${RECIPE_SYSROOT}${libdir}#${libdir}#g" ${D}${ros_datadir}/moveit_ros_perception/cmake/moveit_ros_perceptionTargetsExport.cmake
}
