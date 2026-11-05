# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# NUMPY_INCLUDE_DIRS=/usr/lib/python3/dist-packages/numpy/core/include
# CMake Error: Could NOT find Python3 (missing: Python3_LIBRARIES Python3_NumPy_INCLUDE_DIRS Development NumPy Development.Embed) (found version "3.10.12")
# Use the python3-native and numpy from the sysroot instead of the ones from the host.
ROS_BUILDTOOL_DEPENDS += "python3-numpy-native"
inherit python3native

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package coal contains symlink .so '/opt/ros/jazzy/lib/libcoal.so' [dev-so]
inherit ros_insane_dev_so
