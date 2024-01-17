# Copyright (c) 2022 Wind River Systems, Inc.

# ERROR: QA Issue: rmf-task-sequence: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/rmf_task_sequence
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# rmf-task-sequence: 4 installed and not shipped files. [installed-vs-shipped]
FILES:${PN} += "${datadir}/ament_index/resource_index/packages/rmf_task_sequence"

# Doesn't need runtime dependency on nlohmann-json
ROS_EXEC_DEPENDS:remove = "nlohmann-json"
