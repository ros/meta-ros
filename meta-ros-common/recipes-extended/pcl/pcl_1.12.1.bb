# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require pcl.inc

SRC_URI += "file://0001-MovingLeastSquares-reduce-the-number.patch \
            file://0001-Make-PCL-compatible-with-Boost-1.84-1.12.1.patch \
            file://0002-Do-not-leak-build-directory-paths-1.12.1.patch"

SRCREV = "e8ed4be802f7d0b1acff2f8b01d7c5f381190e05"
