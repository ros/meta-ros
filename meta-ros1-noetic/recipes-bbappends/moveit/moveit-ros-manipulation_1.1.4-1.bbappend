# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-ros-manipulation-1.0.2-1-r0 do_package: QA Issue: moveit-ros-manipulation: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_move_group_pick_place_capability.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_pick_place_planner.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-manipulation: 2 installed and not shipped files. [installed-vs-shipped]
#
# ERROR: moveit-ros-manipulation-1.0.2-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-manipulation path '/work/aarch64-oe-linux/moveit-ros-manipulation/1.0.2-1-r0/packages-split/moveit-ros-manipulation/opt/ros/melodic/lib/libmoveit_pick_place_planner.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-manipulation path '/work/aarch64-oe-linux/moveit-ros-manipulation/1.0.2-1-r0/packages-split/moveit-ros-manipulation/opt/ros/melodic/lib/libmoveit_move_group_pick_place_capability.so' [dev-so]
# ERROR: moveit-ros-manipulation-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
inherit ros_insane_dev_so
