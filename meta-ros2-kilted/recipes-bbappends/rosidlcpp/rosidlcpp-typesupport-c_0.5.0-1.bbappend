# Copyright (c) 2026 Wind River Systems, Inc.

# CMake Error at recipe-sysroot/opt/ros/kilted/share/rcutils/cmake/ament_cmake_export_dependencies-extras.cmake:21 (find_package):
#   Could not find a package configuration file provided by "ament_cmake" with any of the following names:
#     ament_cmakeConfig.cmake
#     ament_cmake-config.cmake
# rcutils exports a dependency on ament_cmake, so it has to be in the sysroot when this package is configured.
ROS_BUILDTOOL_DEPENDS += "ament-cmake-native"
