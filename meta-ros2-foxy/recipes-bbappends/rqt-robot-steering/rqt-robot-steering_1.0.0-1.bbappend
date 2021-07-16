# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: rqt-robot-steering-1.0.0-1-r0 do_package: QA Issue: rqt-robot-steering: Files/directories were installed but not shipped in any package:
#   /usr/share/lib
#   /usr/share/lib/rqt_robot_steering
#   /usr/share/lib/rqt_robot_steering/rqt_robot_steering
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# rqt-robot-steering: 3 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/lib/${ROS_BPN}"
