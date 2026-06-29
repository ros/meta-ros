# Copyright (c) 2025 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

FILESEXTRAPATHS:prepend := "${THISDIR}/${BPN}:"

SRC_URI += "\
    file://0004-Add-Copyright-and-LICENSE-files-37.patch\
    file://0008-Replace-deprecated-ament_target_libraries-with-targe.patch\
    file://0009-Modernize-cmake-50.patch\
    file://0011-Fix-declaration-of-include-directories.patch\
    file://0013-Fix-propagation-of-Boost-random-dependency.patch\
    file://0015-Fix-link-to-Boost-thread-imported-target-52.patch\
"
