# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: rqt-moveit-1.0.1-1-r0 do_package: QA Issue: rqt-moveit: Files/directories were installed but not shipped in any package:
#   /usr/share/lib
#   /usr/share/lib/rqt_moveit
#   /usr/share/lib/rqt_moveit/rqt_moveit
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# rqt-moveit: 3 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/lib/${ROS_BPN}"
