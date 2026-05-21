# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: rmf-utils-1.4.0-2-r0 do_package: QA Issue: rmf-utils: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/rmf_utils
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# rmf-utils: 4 installed and not shipped files. [installed-vs-shipped]
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"

