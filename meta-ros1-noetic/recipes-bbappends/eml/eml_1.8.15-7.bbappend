# Copyright (c) 2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-EMLConfig.cmake-import-from-debian-ro.patch"

# Fails with webOS OSE which by default uses -Werror=return-type
# eml/1.8.15-7-r0/git/eml-svn/tests/posix/master_test.cpp: In function 'void* run_master(void*)':
# eml/1.8.15-7-r0/git/eml-svn/tests/posix/master_test.cpp:127:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"

# package.xml declares "Binary-Only", which is not a valid license identifier.
# Upstream check: source headers are GPL v2 or later (package.xml says 'Binary Only').
LICENSE = "GPL-2.0-or-later"
