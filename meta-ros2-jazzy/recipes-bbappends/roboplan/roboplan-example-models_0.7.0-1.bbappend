# Copyright (c) 2026 Wind River Systems, Inc.

# CMake Error at recipe-sysroot-native/usr/share/cmake-4.4/Modules/CMakeFindDependencyMacro.cmake:93 (find_package):
#   Could not find a package configuration file provided by "tsl-robin-map"
# nanobind needs robin-map when it is built with nanobind_add_module() but python3-nanobind doesn't depend on it.
DEPENDS += "robin-map"

# CMake Error at recipe-sysroot/usr/lib/cmake/nanobind/nanobind-config.cmake:866 (message):
#   nanobind_add_stub(): could not locate 'stubgen.py'!
# Stub generation imports the compiled aarch64 extension on the build host, which can't work when cross compiling.
EXTRA_OECMAKE += "-DGENERATE_PYTHON_STUBS=OFF"
