# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: octomap-1.9.7-1-r0 do_package: QA Issue: octomap: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/octomap
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# octomap: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES_${PN}_prepend = " \
    ${datadir}/ament_index \
"
