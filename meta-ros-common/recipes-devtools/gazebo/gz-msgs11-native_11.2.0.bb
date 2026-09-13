# Copyright (c) 2024-2025 Wind River Systems, Inc.
include gz-msgs11.inc

SRCREV = "3f37a1d723b9d32fcb52883532aae117d7f718dc"

DEPENDS = "gz-cmake4-native gz-math8-native libtinyxml2-native protobuf-native"
EXTRA_OECMAKE += "-DINSTALL_GZ_MSGS_GEN_EXECUTABLE:BOOL=ON"

SYSROOT_DIRS_NATIVE = "${bindir}"

inherit native
