# Copyright (c) 2020 LG Electronics, Inc.

LIC_FILES_CHKSUM = "file://../package.xml;beginline=13;endline=13;md5=a99890d7e16071ac30156cdebd292056"
S = "${WORKDIR}/git/eml-svn"

# Fails with webOS OSE which by default uses -Werror=return-type
# eml/1.8.15-2-r0/git/eml-svn/tests/posix/master_test.cpp:127:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
