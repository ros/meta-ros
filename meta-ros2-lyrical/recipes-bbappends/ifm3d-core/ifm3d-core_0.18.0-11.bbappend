# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-enable-C-language-to-fix-try_compile-.patch \
    file://0002-CMakeLists.txt-drop-s.patch \
"

# CMake Error at CMakeLists.txt:75 (add_subdirectory):
#   add_subdirectory given source \"/usr/src/gtest\" which is not an existing
#   directory.
EXTRA_OECMAKE += "-DBUILD_TESTS=OFF"

inherit ros_insane_dev_so
