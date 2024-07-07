# Copyright (c) 2024 Wind River Systems, Inc.
include gz-msgs10.inc

SRCREV = "78e664a544cdc17e39a86507eec8aaf753a3dbc4"

DEPENDS = "gz-cmake3-native gz-math7-native gz-utils2-native libtinyxml2-native protobuf-native"
EXTRA_OECMAKE += "-DINSTALL_GZ_MSGS_GEN_EXECUTABLE:BOOL=ON"

inherit native
