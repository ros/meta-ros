# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: QA Issue: moveit-kinematics: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/melodic/lib/libmoveit_cached_ik_kinematics_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_kdl_kinematics_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_srv_kinematics_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_lma_kinematics_plugin.so.1.0.2
#   /usr/opt/ros/melodic/lib/libmoveit_cached_ik_kinematics_base.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-kinematics: 5 installed and not shipped files. [installed-vs-shipped]
inherit ros_insane_dev_so
