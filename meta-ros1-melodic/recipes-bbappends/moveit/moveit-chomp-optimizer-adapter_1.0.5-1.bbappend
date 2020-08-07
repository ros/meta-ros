# Copyright (c) 2020 LG Electronics, Inc.

# ERROR: QA Issue: moveit-chomp-optimizer-adapter: Files/directories were installed but not shipped in any package:
#   /usr/opt/ros/melodic/lib/libmoveit_chomp_optimizer_adapter.so.1.0.2
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# moveit-chomp-optimizer-adapter: 1 installed and not shipped files. [installed-vs-shipped]
inherit ros_insane_dev_so
