# Copyright (c) 2024 Wind River Systems, Inc.
include gz-msgs10.inc

SRCREV = "876b89d5cab32d9ddfd5f95ce8cf365ce77f27ef"

SRC_URI += "file://fix-compatibility-with-protobuf-v30.patch"

DEPENDS = "gz-cmake3-native gz-math7-native gz-utils2-native libtinyxml2-native protobuf-native"
EXTRA_OECMAKE += "-DINSTALL_GZ_MSGS_GEN_EXECUTABLE:BOOL=ON"

SYSROOT_DIRS_NATIVE = "${bindir}"

inherit native
