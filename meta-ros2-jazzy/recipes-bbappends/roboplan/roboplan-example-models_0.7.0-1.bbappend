# Copyright (c) 2026 Wind River Systems, Inc.

# CMake Error at recipe-sysroot-native/usr/share/cmake-4.4/Modules/CMakeFindDependencyMacro.cmake:93 (find_package):
#   Could not find a package configuration file provided by "tsl-robin-map"
# nanobind needs robin-map when it is built with nanobind_add_module() but python3-nanobind doesn't depend on it.
DEPENDS += "robin-map"
