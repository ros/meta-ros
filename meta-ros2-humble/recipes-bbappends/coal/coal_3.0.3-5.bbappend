# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# NUMPY_INCLUDE_DIRS=/usr/lib/python3/dist-packages/numpy/core/include
# CMake Error: Could NOT find Python3 (missing: Python3_LIBRARIES Python3_NumPy_INCLUDE_DIRS Development NumPy Development.Embed) (found version "3.10.12")
# Use the python3-native and numpy from the sysroot instead of the ones from the host.
ROS_BUILDTOOL_DEPENDS += "python3-numpy-native"
inherit python3native

# ERROR: QA Issue: non -dev/-dbg/nativesdk- package coal contains symlink .so '/opt/ros/humble/lib/libcoal.so' [dev-so]
inherit ros_insane_dev_so

# pinocchio: CMake Error at recipe-sysroot/opt/ros/humble/lib/cmake/coal/coalTargets.cmake:92 (message):
#   The imported target "coal::coal_pywrap" references the file
#     "/opt/ros/humble/lib/python3.14/site-packages/coal/coal_pywrap.cpython-314-x86_64-linux-gnu.so"
#   but this file does not exist.
# The python module is exported with an absolute path, make it relative to the install prefix.
do_install:append() {
    sed -i -e 's#"${ros_prefix}/lib/python#"${_IMPORT_PREFIX}/lib/python#g' ${D}${ros_prefix}/lib/cmake/coal/coalTargets-*.cmake
}
