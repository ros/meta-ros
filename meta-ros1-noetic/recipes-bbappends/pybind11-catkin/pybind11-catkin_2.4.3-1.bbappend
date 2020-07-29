# Copyright (c) 2020 LG Electronics, Inc.

# Otherwise picks native python instead of the target one and fails with:
# | Re-run cmake no build system arguments
# | CMake Error at tools/FindPythonLibsNew.cmake:127 (message):
# |   Python config failure: Python is 64-bit, chosen compiler is 32-bit
# | Call Stack (most recent call first):
# |   tools/pybind11Tools.cmake:16 (find_package)
# |   CMakeLists.txt:33 (include)
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-pybind11-tools-FindPythonLibsNew.cmake-ignore-pointe.patch"
