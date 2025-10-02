# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

require pcl.inc

SRC_URI += "file://prepare-for-boost-1.87.patch \
            file://compatibility-with-clang-19.patch \
            file://fix-build-with-boost-1.89.0.patch"

SRCREV = "5f608cfb5397fe848c7d61c4ae5f5b1ab760ba80"
