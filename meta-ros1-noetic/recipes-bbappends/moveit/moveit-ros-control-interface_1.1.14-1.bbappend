# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: QA Issue: moveit-ros-control-interface: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/melodic/lib/libmoveit_ros_control_interface_trajectory_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_ros_control_interface_plugin.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-control-interface: 2 installed and not shipped files. [installed-vs-shipped]
inherit ros_insane_dev_so
