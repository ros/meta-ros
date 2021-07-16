# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: rqt-gui-1.1.1-1-r0 do_package: QA Issue: rqt-gui: Files/directories were installed but not shipped in any package:
#  /usr/share/lib
#  /usr/share/lib/rqt_gui
#  /usr/share/lib/rqt_gui/rqt_gui
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# rqt-gui: 3 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/lib/${ROS_BPN}"
