# Copyright (c) 2021 LG Electronics, Inc.

# ERROR: ros-industrial-cmake-boilerplate-0.2.8-1-r0 do_package: QA Issue: ros-industrial-cmake-boilerplate: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/ros_industrial_cmake_boilerplate
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# ros-industrial-cmake-boilerplate: 4 installed and not shipped files. [installed-vs-shipped]
do_install:append() {
    rm -rf ${D}${datadir}/ament_index
}
