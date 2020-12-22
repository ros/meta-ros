# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-ros-move-group-1.0.2-1-r0 do_package: QA Issue: moveit-ros-move-group: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_move_group_capabilities_base.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_move_group_default_capabilities.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-move-group: 2 installed and not shipped files. [installed-vs-shipped]
#
# ERROR: moveit-ros-move-group-1.0.2-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-move-group path '/work/aarch64-oe-linux/moveit-ros-move-group/1.0.2-1-r0/packages-split/moveit-ros-move-group/opt/ros/melodic/lib/libmoveit_move_group_default_capabilities.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-move-group path '/work/aarch64-oe-linux/moveit-ros-move-group/1.0.2-1-r0/packages-split/moveit-ros-move-group/opt/ros/melodic/lib/libmoveit_move_group_capabilities_base.so' [dev-so]
# ERROR: moveit-ros-move-group-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/moveit_ros_move_group/move_group contained in package moveit-ros-move-group requires libmoveit_move_group_capabilities_base.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-move-group? [file-rdeps]
# ERROR: moveit-ros-move-group-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
inherit ros_insane_dev_so
