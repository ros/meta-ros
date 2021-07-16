# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: pr2-tuck-arms-action-0.0.12-1-r0 do_package: QA Issue: pr2-tuck-arms-action: Files/directories were installed but not shipped in any package:
#   /opt/ros/noetic/lib/pr2_tuck_arms_action
#   /opt/ros/noetic/lib/pr2_tuck_arms_action/tuck_arms.py
#   /opt/ros/noetic/lib/pr2_tuck_arms_action/tuck_arms_main.py
#   /opt/ros/noetic/lib/pr2_tuck_arms_action/tuck_arms_test.py
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# pr2-tuck-arms-action: 4 installed and not shipped files. [installed-vs-shipped
FILES:${PN} += "${ros_libdir}/${ROS_BPN}"
