# Copyright (c) 2020 LG Electronics, Inc.

# WARNING: moveit-ros-robot-interaction-1.0.2-1-r0 do_package: QA Issue: moveit-ros-robot-interaction: Files/directories were installed but not shipped in any package:
#   /opt/ros/melodic/lib/libmoveit_robot_interaction.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-ros-robot-interaction: 1 installed and not shipped files. [installed-vs-shipped]

# ERROR: moveit-ros-robot-interaction-1.0.2-1-r0 do_package_qa: QA Issue:
# non -dev/-dbg/nativesdk- package contains symlink .so: moveit-ros-robot-interaction path '/work/core2-64-oe-linux/moveit-ros-robot-interaction/1.0.2-1-r0/packages-split/moveit-ros-robot-interaction/opt/ros/melodic/lib/libmoveit_robot_interaction.so' [dev-so]
# ERROR: moveit-ros-robot-interaction-1.0.2-1-r0 do_package_qa: QA run found fatal errors. Please consider fixing them.
# ERROR: moveit-ros-robot-interaction-1.0.2-1-r0 do_package_qa: Function failed: do_package_qa
inherit ros_insane_dev_so
