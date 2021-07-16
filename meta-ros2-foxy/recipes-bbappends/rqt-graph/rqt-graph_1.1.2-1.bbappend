# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: rqt-graph-1.1.2-1-r0 do_package: QA Issue: rqt-graph: Files/directories were installed but not shipped in any package:
#   /usr/share/lib
#   /usr/share/lib/rqt_graph
#   /usr/share/lib/rqt_graph/rqt_graph
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# rqt-graph: 3 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/lib/${ROS_BPN}"
