# Copyright (c) 2025 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS:append = " \
    ament-cmake-native \
    ament-cmake-core-native \
    ament-cmake-export-definitions-native \
    ament-cmake-export-dependencies-native \
    ament-cmake-export-include-directories-native \
    ament-cmake-export-interfaces-native \
    ament-cmake-export-libraries-native \
    ament-cmake-export-link-flags-native \
    ament-cmake-export-targets-native \
    ament-cmake-gen-version-h-native \
    ament-cmake-libraries-native \
    ament-cmake-python-native \
    ament-cmake-target-dependencies-native \
    ament-cmake-test-native \
    ament-cmake-version-native \
    cmake-native \
"

BBCLASSEXTEND = "native nativesdk"
