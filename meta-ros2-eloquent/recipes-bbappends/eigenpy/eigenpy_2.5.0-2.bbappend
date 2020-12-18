# Copyright (c) 2020 LG Electronics, Inc.

# Otherwise fails to find python3
# | CMake Error at /jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/eigenpy/2.5.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.16/Modules/FindPackageHandleStandardArgs.cmake:146 (message):
# |   Could NOT find Python3 (missing: Python3_LIBRARIES Python3_INCLUDE_DIRS
# |   Development) (found version "3.6.9")
# | Call Stack (most recent call first):
# |   /jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/eigenpy/2.5.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.16/Modules/FindPackageHandleStandardArgs.cmake:393 (_FPHSA_FAILURE_MESSAGE)
# |   /jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/eigenpy/2.5.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.16/Modules/FindPython/Support.cmake:2261 (find_package_handle_standard_args)
# |   /jenkins/mjansa/build/ros/webos-foxy-dunfell/tmp-glibc/work/qemux86-webos-linux/eigenpy/2.5.0-1-r0/recipe-sysroot-native/usr/share/cmake-3.16/Modules/FindPython3.cmake:300 (include)
# |   cmake/python.cmake:92 (FIND_PACKAGE)
# |   CMakeLists.txt:61 (FINDPYTHON)
inherit python3native

# | CMake Error at cmake/python.cmake:482 (MESSAGE):
# |   Failed to detect numpy
DEPENDS += "python3-numpy-native"
