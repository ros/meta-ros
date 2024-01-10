# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += " \
    ros-industrial-cmake-boilerplate-native \
"

# ERROR: boost-plugin-loader-0.2.1-1-r0 do_package: QA Issue: boost-plugin-loader: Files/directories were installed but not shipped in any package:
#   /usr/share/ament_index
#   /usr/share/ament_index/resource_index
#   /usr/share/ament_index/resource_index/packages
#   /usr/share/ament_index/resource_index/packages/boost_plugin_loader
# Please set FILES such that these items are packaged. Alternatively if they are unneeded, avoid installing them or delete them within do_install.
# boost-plugin-loader: 4 installed and not shipped files. [installed-vs-shipped]
# ERROR: boost-plugin-loader-0.2.1-1-r0 do_package: Fatal QA errors were found, failing task.
#
# ros_ament_cmake.bbclass does this automatically, but this recipe inherits just ros_cmake.bbclass
FILES:${PN}:prepend = " \
    ${datadir}/ament_index \
"
