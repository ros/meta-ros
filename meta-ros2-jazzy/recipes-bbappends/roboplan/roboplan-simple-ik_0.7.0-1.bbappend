# Copyright (c) 2026 Wind River Systems, Inc.

# CMake Error at recipe-sysroot/opt/ros/jazzy/lib/cmake/eigenpy/python.cmake:563 (message):
#   Failed to detect numpy
# eigenpy and pinocchio look for python and numpy through the host python3 unless python3native is inherited.
ROS_BUILDTOOL_DEPENDS += "python3-numpy-native"
inherit python3native
