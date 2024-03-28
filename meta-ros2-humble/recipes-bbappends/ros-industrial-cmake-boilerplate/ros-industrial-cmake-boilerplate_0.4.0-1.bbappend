# Copyright (c) 2023 Wind River Systems, Inc.

# ERROR: QA Issue: ros-industrial-cmake-boilerplate: Files/directories were installed but not shipped in any package:
#  /usr/share/ament_index
#  /usr/share/ament_index/resource_index
#  /usr/share/ament_index/resource_index/packages
#  /usr/share/ament_index/resource_index/packages/ros_industrial_cmake_boilerplate
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# ros-industrial-cmake-boilerplate: 4 installed and not shipped files. [installed-vs-shipped]

# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index/resource_index/packages/ros_industrial_cmake_boilerplate \
"

BBCLASSEXTEND = "native nativesdk"
