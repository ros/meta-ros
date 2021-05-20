# Copyright (c) 2020-2021 LG Electronics, Inc.

# Instead of fetching
# https://github.com/pybind/pybind11/archive/v2.5.0.zip with curl
# during do_compile
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fetch-pybind11-with-bitbake-fetcher.patch \
    git://github.com/pybind/pybind11.git;protocol=https;name=pybind11-upstream;destsuffix=git/pybind11-upstream \
"

SRCREV_pybind11-upstream = "014cd12ec1a3258f3bfc6597f371ed46c8e89ccd"

# Otherwise picks native python instead of the target one and fails with:
# | Re-run cmake no build system arguments
# | CMake Error at tools/FindPythonLibsNew.cmake:127 (message):
# |   Python config failure: Python is 64-bit, chosen compiler is 32-bit
# | Call Stack (most recent call first):
# |   tools/pybind11Tools.cmake:16 (find_package)
# |   CMakeLists.txt:33 (include)
SRC_URI += "file://0001-pybind11-tools-FindPythonLibsNew.cmake-ignore-pointe.patch;patchdir=pybind11-upstream"
