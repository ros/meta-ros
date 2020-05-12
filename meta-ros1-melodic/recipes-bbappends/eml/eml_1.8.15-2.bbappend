# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-EMLConfig.cmake-import-from-debian-ro.patch"

# Fails with webOS OSE which by default uses -Werror=return-type
# eml/1.8.15-2-r0/git/eml-svn/tests/posix/master_test.cpp:127:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
