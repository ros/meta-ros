# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: ur-client-library: Files/directories were installed but not shipped in any package:
#  /usr/share/ament_index
#  /usr/share/ament_index/resource_index
#  /usr/share/ament_index/resource_index/packages
#  /usr/share/ament_index/resource_index/packages/ur_client_library
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# ur-client-library: 4 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/ament_index/resource_index/packages/ur_client_library"
