# Copyright (c) 2020-2021 LG Electronics, Inc.

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-CMakeLists.txt-fix-build-without-catkin-testing-enab.patch \
    file://0001-atomic-use-static-inline-for-atomic_thread_fence-and.patch \
"
