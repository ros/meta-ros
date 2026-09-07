# Copyright (c) 2024-2025 Wind River Systems, Inc.
include gz-msgs_12.0.2.inc

SRCREV = "703d291e80e90df00f9ec0c44a9ee1f399939c09"

DEPENDS = "gz-cmake-native gz-math-native libtinyxml2-native protobuf-native"
EXTRA_OECMAKE += "-DINSTALL_GZ_MSGS_GEN_EXECUTABLE:BOOL=ON"

SYSROOT_DIRS_NATIVE = "${bindir}"

inherit native
