# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: launch-param-builder: Files/directories were installed but not shipped in any package:
#   /usr/share/lib
#   /usr/share/lib/launch_param_builder
#   /usr/share/lib/launch_param_builder/example_node.py
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# launch-param-builder: 3 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/lib/launch_param_builder"
