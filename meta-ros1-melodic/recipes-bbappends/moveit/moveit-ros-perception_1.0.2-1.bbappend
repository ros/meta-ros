# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-ros-perception-1.0.2-1-r0 do_package: QA Issue: moveit-ros-perception: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_lazy_free_space_updater.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_point_containment_filter.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_pointcloud_octomap_updater_core.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_occupancy_map_monitor.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_pointcloud_octomap_updater.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_semantic_world.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_mesh_filter.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_depth_image_octomap_updater.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_depth_image_octomap_updater_core.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-perception: 9 installed and not shipped files. [installed-vs-shipped]

# ERROR: moveit-ros-perception-1.0.2-1-r0 do_package_qa: QA Issue: non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_point_containment_filter.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_occupancy_map_monitor.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_depth_image_octomap_updater.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_depth_image_octomap_updater_core.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_lazy_free_space_updater.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_pointcloud_octomap_updater_core.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_pointcloud_octomap_updater.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_mesh_filter.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-perception path '/work/core2-64-oe-linux/moveit-ros-perception/1.0.2-1-r0/packages-split/moveit-ros-perception/opt/ros/melodic/lib/libmoveit_semantic_world.so' [dev-so]
inherit ros_insane_dev_so
