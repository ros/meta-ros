# Copyright (c) 2022 Wind River Systems, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

# CMake Error at CMakeLists.txt:40 (MESSAGE):
#   32 bits compiler detected.  Libpointmatcher is only supported in 64 bits.
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:aarch64 = "(.*)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"

SRC_URI += "file://0001-Make-yaml-cpp-pm-use-cmake-clean.patch"
