# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022-2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS = " \
    rosidl-adapter-native \
    python3-numpy-native \
    generate-parameter-library-py-native \
"

# tf2-kdl and angles are only in ROS_TEST_DEPENDS but CMake checks for it even with testing disabled
DEPENDS += "\
    tf2-kdl \
    pluginlib \
    angles \
"

# ERROR: moveit-core-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_background_processing.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_constraint_samplers.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_trajectory_processing.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_collision_distance_field.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_kinematics_metrics.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_profiler.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_dynamics_solver.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_exceptions.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_robot_model.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_utils.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_planning_interface.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_kinematics_base.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_distance_field.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_collision_detection_fcl.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_transforms.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_robot_state.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_collision_detection.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_kinematic_constraints.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_planning_scene.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libcollision_detector_fcl_plugin.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_planning_request_adapter.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-core path '/work/raspberrypi4-webos-linux-gnueabi/moveit-core/2.1.0-1-r0/packages-split/moveit-core/usr/lib/libmoveit_robot_trajectory.so'
# [dev-so]
inherit ros_insane_dev_so
inherit pkgconfig
