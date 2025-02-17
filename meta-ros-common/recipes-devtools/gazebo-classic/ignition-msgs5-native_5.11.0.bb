# Copyright (c) 2024 Wind River Systems, Inc.

include ignition-msgs5.inc

DEPENDS = "ignition-cmake2-native ignition-math6-native libtinyxml2-native protobuf-native"

EXTRA_OECMAKE += "-DINSTALL_IGN_MSGS_GEN_EXECUTABLE:BOOL=ON"

inherit native
