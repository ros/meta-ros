# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-drop-obsolete-Boost-System-component.patch"

EXTRA_OECMAKE:append = " -DCMAKE_POLICY_VERSION_MINIMUM=3.5"
