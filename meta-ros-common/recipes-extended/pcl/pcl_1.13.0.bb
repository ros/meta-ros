# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require pcl.inc

SRC_URI += "file://0001-MovingLeastSquares-reduce-the-number.patch \
            file://0001-Make-PCL-compatible-with-Boost-1.84-1.13.0.patch \
            file://0002-Do-not-leak-build-directory-paths-1.13.0.patch \
            file://fix-missing-include.patch \
            file://add-directory-header.patch \
            file://replace-deprecated-boost-filesystem-extension.patch \
            file://replace-deprecated-boost-filesystem-basename.patch \
            file://prepare-for-boost-1.87.patch"

SRCREV = "371a8e1373f7b2f66bbb92291be2f3e50dc19856"
