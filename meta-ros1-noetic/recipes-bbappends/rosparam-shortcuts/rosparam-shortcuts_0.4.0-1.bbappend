# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-add-missing-eigen_conversions-to-CATK.patch"

EXTRA_OECMAKE = "-DCMAKE_POLICY_VERSION_MINIMUM=3.5"
