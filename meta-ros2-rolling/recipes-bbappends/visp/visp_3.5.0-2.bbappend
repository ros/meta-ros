# Copyright (c) 2022 Wind River Systems, Inc.

# x86_64-oe-linux-g++: warning: 2: linker input file unused because linking not done
# x86_64-oe-linux-g++: error: 2: linker input file not found: No such file or directory
FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-Do-not-use-regex-on-CXXFLAGS.patch"
