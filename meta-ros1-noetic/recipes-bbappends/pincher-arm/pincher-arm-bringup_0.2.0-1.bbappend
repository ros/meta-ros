# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: pincher-arm-bringup-0.2.0-1-r0 do_package: QA Issue: pincher-arm-bringup: Files/directories were installed but not shipped in any package:
#   /opt/ros/noetic/lib/pincher_arm_bringup
#   /opt/ros/noetic/lib/pincher_arm_bringup/gripper_transmission
#   /opt/ros/noetic/lib/pincher_arm_bringup/fake_joint_pub
#   /opt/ros/noetic/lib/pincher_arm_bringup/gripper_controller
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# pincher-arm-bringup: 4 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${ros_libdir}/${ROS_BPN}"
