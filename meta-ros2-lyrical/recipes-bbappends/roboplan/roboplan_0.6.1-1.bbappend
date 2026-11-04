# Copyright (c) 2026 Wind River Systems, Inc.

# CMake Error at recipe-sysroot/opt/ros/lyrical/lib/cmake/eigenpy/python.cmake:563 (message):
#   Failed to detect numpy
# eigenpy and pinocchio look for python and numpy through the host python3 unless python3native is inherited.
ROS_BUILDTOOL_DEPENDS += "python3-numpy-native"
inherit python3native

# CMake Error at recipe-sysroot/usr/lib/cmake/nanobind/nanobind-config.cmake:307 (find_dependency):
#   Could not find a package configuration file provided by "tsl-robin-map"
# nanobind needs robin-map when it is built with nanobind_add_module() but python3-nanobind doesn't depend on it.
DEPENDS += "robin-map"

# CMake Error at recipe-sysroot/usr/lib/cmake/nanobind/nanobind-config.cmake:866 (message):
#   nanobind_add_stub(): could not locate 'stubgen.py'!
# Stub generation imports the compiled aarch64 extension on the build host, which can't work when cross compiling.
# The .pyi stubs are committed in the source tree, so they are still installed.
EXTRA_OECMAKE += "-DGENERATE_PYTHON_STUBS=OFF"

# CMake Error at recipe-sysroot/usr/lib/cmake/nanobind/nanobind-config.cmake:158 (add_library):
#   Cannot find source file: recipe-sysroot/usr/lib/cmake/include/nanobind/eval.h
# python3-nanobind copies nanobind-config.cmake to ${libdir}/cmake/nanobind, but the file finds the nanobind
# sources relative to its own location. Use the config in the python package instead.
EXTRA_OECMAKE += "-Dnanobind_DIR=${STAGING_LIBDIR}/${PYTHON_DIR}/site-packages/nanobind/cmake"
