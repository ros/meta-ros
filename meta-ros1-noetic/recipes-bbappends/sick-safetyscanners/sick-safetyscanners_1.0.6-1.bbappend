# Copyright (c) 2020 LG Electronics, Inc.

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-AsyncTCPClient.cpp-fix-boost-system-error_code-use.patch"
