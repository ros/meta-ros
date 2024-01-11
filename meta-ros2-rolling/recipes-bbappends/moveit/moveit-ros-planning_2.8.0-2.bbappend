# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    generate-parameter-library-py-native \
"

# ERROR: moveit-ros-planning-2.1.0-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_default_planning_request_adapter_plugins.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_kinematics_plugin_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_planning_scene_monitor.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_rdf_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_planning_pipeline.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_collision_plugin_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_robot_model_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_constraint_sampler_manager_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_plan_execution.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/raspberrypi4-webos-linux-gnueabi/moveit-ros-planning/2.1.0-1-r0/packages-split/moveit-ros-planning/usr/lib/libmoveit_trajectory_execution_manager.so'
# [dev-so]
inherit ros_insane_dev_so
