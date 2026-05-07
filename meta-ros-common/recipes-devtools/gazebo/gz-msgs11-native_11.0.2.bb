# Copyright (c) 2024-2025 Wind River Systems, Inc.
include gz-msgs11.inc

SRCREV = "21a942be1223e08c9b42c5aefb29e0414e9ddd2a"

S = "${WORKDIR}/git"

SRC_URI += "file://fix-compatibility-with-protobuf-v30.patch \
            file://update-protobuf-dep.patch \
            file://override-generator-scripts.patch"

DEPENDS = "gz-cmake4-native gz-math8-native libtinyxml2-native protobuf-native"
EXTRA_OECMAKE += "-DINSTALL_GZ_MSGS_GEN_EXECUTABLE:BOOL=ON"

SYSROOT_DIRS_NATIVE = "${bindir}"

inherit native
