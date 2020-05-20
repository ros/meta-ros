# Copyright (c) 2019-2020 LG Electronics, Inc.

BBCLASSEXTEND = "native"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-examples-cpp03-fix-build-without-std-chrono.patch"
