# Copyright (c) 2024-2025 Wind River Systems, Inc.
include gz-msgs11.inc

SRCREV = "1f5f19e44faaaa8ece97903eb09b685b4640dea1"

DEPENDS = "gz-cmake4-native gz-math8-native libtinyxml2-native protobuf-native"
EXTRA_OECMAKE += "-DINSTALL_GZ_MSGS_GEN_EXECUTABLE:BOOL=ON"

SYSROOT_DIRS_NATIVE = "${bindir}"

inherit native
