# Copyright (c) 2020 LG Electronics, Inc.

do_configure_append() {
    # Fixes this:
    # moveit-core/1.0.2-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cmath:45:15: fatal error: math.h: No such file or directory
    # moveit-core/1.0.2-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cstdlib:75:15: fatal error: stdlib.h: No such file or directory
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}

# angles dependency should be used only when catkin testing
# is enabled, which in our builds isn't
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-trajectory_processing-remove-unnecessary-angles-angl.patch"

# WARNING: moveit-core-1.0.2-1-r0 do_package: QA Issue: moveit-core: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_collision_detection.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_collision_detection_fcl.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_background_processing.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_exceptions.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_profiler.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_planning_scene.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_distance_field.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_planning_interface.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_kinematics_base.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_robot_model.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_kinematic_constraints.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_transforms.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_constraint_samplers.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_collision_distance_field.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_kinematics_metrics.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_trajectory_processing.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_utils.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_robot_state.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_robot_trajectory.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_test_utils.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_dynamics_solver.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_planning_request_adapter.so.1.0.2
#   /opt/ros/melodic/lib/libcollision_detector_fcl_plugin.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-core: 23 installed and not shipped files. [installed-vs-shipped]
FILES_${PN} += "${ros_libdir}/*${SOLIBS}"

# ERROR: moveit-core-1.0.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_background_processing.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_constraint_samplers.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_trajectory_processing.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_test_utils.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_collision_distance_field.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_kinematics_metrics.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_profiler.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_dynamics_solver.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_exceptions.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_robot_model.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_utils.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_planning_interface.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_kinematics_base.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_distance_field.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_collision_detection_fcl.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_transforms.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_robot_state.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_collision_detection.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_kinematic_constraints.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_planning_scene.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libcollision_detector_fcl_plugin.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_planning_request_adapter.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/core2-64-oe-linux/moveit-core/1.0.2-1-r0/packages-split/moveit-core/opt/ros/melodic/lib/libmoveit_robot_trajectory.so' [dev-so]
inherit ros_insane_dev_so

# Just to get rid of bogus QA issue, because both fcl and fcl-catkin provide the same libfcl.so.0.6 library, luckily in different paths (so that they don't conflict in RSS):
# fcl-catkin: /opt/ros/melodic/lib/libfcl.so.0.6
# fcl: /usr/lib/libfcl.so.0.6
# which confuses shlibs code and causes:
# ERROR: QA Issue: moveit-core rdepends on fcl-catkin, but it isn't a build dependency, missing fcl-catkin in DEPENDS or PACKAGECONFIG? [build-deps]
DEPENDS += "fcl-catkin"
