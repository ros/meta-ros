# Copyright (c) 2024 Wind River Systems, Inc.
include gz-msgs10.inc

SRCREV = "3c0ca9455a9686d71c4d7819417e434ae1b47ad6"

DEPENDS = "gz-cmake3-native gz-math7-native gz-utils2-native libtinyxml2-native protobuf-native"
EXTRA_OECMAKE += "-DINSTALL_GZ_MSGS_GEN_EXECUTABLE:BOOL=ON"

SYSROOT_DIRS_NATIVE = "${bindir}"

inherit native
