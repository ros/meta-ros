# Copyright (c) 2025 Wind River Systems, Inc.

inherit python3targetconfig

ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-lint-cmake \
    ament-cmake-copyright \
    ament-cmake-xmllint \
    ament-copyright \
    ament-lint-cmake \
    ament-package \
    ament-xmllint \
    ignition-cmake2 \
"

BBCLASSEXTEND = "native nativesdk"

