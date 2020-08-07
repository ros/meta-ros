# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: QA Issue: chomp-motion-planner: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/melodic/lib/libchomp_motion_planner.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# chomp-motion-planner: 1 installed and not shipped files. [installed-vs-shipped]
inherit ros_insane_dev_so
