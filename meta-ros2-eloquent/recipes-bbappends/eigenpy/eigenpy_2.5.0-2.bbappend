# Copyright (c) 2020-2021 LG Electronics, Inc.

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

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-core-fix-typedef.patch \
    file://0002-core-fix-compatibility-with-Boost.Python-1.77.patch \
    file://0003-core-fix-typedef.patch \
"

# otherwise eigen's FINDPYTHON function will find hosttools/python3 first
# (due to python3 in PYTHON_EXECUTABLE from https://github.com/wxmerkt/eigenpy-ros-release/commit/7329412c27acd6f09929ecc0bd7914d37153954a)
# instead of respecting PYTHON_EXECUTABLE/Python_EXECUTABLE variables from
# EXTRA_OECMAKE (set to ${PYTHON} by meta/classes/cmake.bbclass)
# causing python3-numpy search to fail (unless it's installed on host OS) and
# installing the files in wrong location (lib/python3/dist-packages
# instead of lib/python3.8/dist-packages which is included in FILES:${PN})
SRC_URI += "file://0002-Only-set-CMake-variables-if-not-set-cf.-2.patch"
