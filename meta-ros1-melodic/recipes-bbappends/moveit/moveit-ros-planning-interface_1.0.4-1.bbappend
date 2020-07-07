# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-ros-planning-interface-1.0.2-1-r0 do_package: QA Issue: moveit-ros-planning-interface: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_planning_scene_interface.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_move_group_interface.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_py_bindings_tools.so.1.0.2
#   /opt/ros/melodic/lib/libmoveit_common_planning_interface_objects.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-planning-interface: 4 installed and not shipped files. [installed-vs-shipped]
#
# ERROR: moveit-ros-planning-interface-1.0.2-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning-interface path '/work/aarch64-oe-linux/moveit-ros-planning-interface/1.0.2-1-r0/packages-split/moveit-ros-planning-interface/opt/ros/melodic/lib/libmoveit_planning_scene_interface.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning-interface path '/work/aarch64-oe-linux/moveit-ros-planning-interface/1.0.2-1-r0/packages-split/moveit-ros-planning-interface/opt/ros/melodic/lib/libmoveit_move_group_interface.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning-interface path '/work/aarch64-oe-linux/moveit-ros-planning-interface/1.0.2-1-r0/packages-split/moveit-ros-planning-interface/opt/ros/melodic/lib/libmoveit_common_planning_interface_objects.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning-interface path '/work/aarch64-oe-linux/moveit-ros-planning-interface/1.0.2-1-r0/packages-split/moveit-ros-planning-interface/opt/ros/melodic/lib/libmoveit_py_bindings_tools.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning-interface path '/work/aarch64-oe-linux/moveit-ros-planning-interface/1.0.2-1-r0/packages-split/moveit-ros-planning-interface/opt/ros/melodic/lib/python2.7/site-packages/moveit_ros_planning_interface/_moveit_planning_scene_interface.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning-interface path '/work/aarch64-oe-linux/moveit-ros-planning-interface/1.0.2-1-r0/packages-split/moveit-ros-planning-interface/opt/ros/melodic/lib/python2.7/site-packages/moveit_ros_planning_interface/_moveit_move_group_interface.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning-interface path '/work/aarch64-oe-linux/moveit-ros-planning-interface/1.0.2-1-r0/packages-split/moveit-ros-planning-interface/opt/ros/melodic/lib/python2.7/site-packages/moveit_ros_planning_interface/_moveit_robot_interface.so'
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-planning-interface path '/work/aarch64-oe-linux/moveit-ros-planning-interface/1.0.2-1-r0/packages-split/moveit-ros-planning-interface/opt/ros/melodic/lib/python2.7/site-packages/moveit_ros_planning_interface/_moveit_roscpp_initializer.so' [dev-so]
# ERROR: moveit-ros-planning-interface-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/python2.7/site-packages/moveit_ros_planning_interface/_moveit_move_group_interface.so.1.0.2 contained in package moveit-ros-planning-interface requires libmoveit_move_group_interface.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-planning-interface? [file-rdeps]
# ERROR: moveit-ros-planning-interface-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/python2.7/site-packages/moveit_ros_planning_interface/_moveit_roscpp_initializer.so.1.0.2 contained in package moveit-ros-planning-interface requires libmoveit_py_bindings_tools.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-planning-interface? [file-rdeps]
# ERROR: moveit-ros-planning-interface-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/python2.7/site-packages/moveit_ros_planning_interface/_moveit_planning_scene_interface.so.1.0.2 contained in package moveit-ros-planning-interface requires libmoveit_planning_scene_interface.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-planning-interface? [file-rdeps]
# ERROR: moveit-ros-planning-interface-1.0.2-1-r0 do_package_qa: QA Issue: /opt/ros/melodic/lib/python2.7/site-packages/moveit_ros_planning_interface/_moveit_robot_interface.so.1.0.2 contained in package moveit-ros-planning-interface requires libmoveit_common_planning_interface_objects.so.1.0.2()(64bit), but no providers found in RDEPENDS_moveit-ros-planning-interface? [file-rdeps]
# ERROR: moveit-ros-planning-interface-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
inherit ros_insane_dev_so
