# Copyright (c) 2024-2025 Wind River Systems, Inc.
include gz-msgs_12.0.1.inc

SRCREV = "a5576425f1a3d9f736e6758005696aac32f93461"

DEPENDS = "gz-cmake-native gz-math-native libtinyxml2-native protobuf-native"
EXTRA_OECMAKE += "-DINSTALL_GZ_MSGS_GEN_EXECUTABLE:BOOL=ON"

SYSROOT_DIRS_NATIVE = "${bindir}"

inherit native
