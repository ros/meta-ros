# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-ros-planning-1.0.2-1-r0 do_package: QA Issue: moveit-ros-planning: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_plan_execution.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_robot_model_loader.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_kinematics_plugin_loader.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_collision_plugin_loader.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_constraint_sampler_manager_loader.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_trajectory_execution_manager.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_rdf_loader.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_planning_scene_monitor.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_default_planning_request_adapter_plugins.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_planning_pipeline.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-planning: 10 installed and not shipped files. [installed-vs-shipped]
# ERROR: moveit-ros-planning-1.0.2-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_default_planning_request_adapter_plugins.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_kinematics_plugin_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_planning_scene_monitor.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_rdf_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_planning_pipeline.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_collision_plugin_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_robot_model_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_constraint_sampler_manager_loader.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_plan_execution.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning path '/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/packages-split/moveit-ros-planning/opt/ros/melodic/lib/libmoveit_trajectory_execution_manager.so' [dev-so]
# ERROR: moveit-ros-planning-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/moveit_ros_planning/moveit_visualize_robot_collision_volume contained in package moveit-ros-planning requires libmoveit_planning_scene_monitor.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-planning? [file-rdeps]
# ERROR: moveit-ros-planning-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/moveit_ros_planning/moveit_publish_scene_from_text contained in package moveit-ros-planning requires libmoveit_robot_model_loader.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-planning? [file-rdeps]
# ERROR: moveit-ros-planning-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
# ERROR: moveit-ros-planning-1.0.2-1-r0 do_package_qa: Function failed: do_package_qa
# ERROR: Logfile of failure stored in: /jenkins/mjansa/build/ros/ros1-melodic-thud/tmp-glibc/work/core2-64-oe-linux/moveit-ros-planning/1.0.2-1-r0/temp/log.do_package_qa.12621
# ERROR: Task (/jenkins/mjansa/build/ros/ros1-melodic-thud/meta-ros/meta-ros1-melodic/generated-recipes/moveit/moveit-ros-planning_1.0.2-1.bb:do_package_qa) failed with exit code '1'
inherit ros_insane_dev_so
