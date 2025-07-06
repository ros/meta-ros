# Copyright (c) 2019-2021 LG Electronics, Inc.
# Copyright (c) 2025 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS:append = " \
    ament-cmake-native \
    ament-cmake-core-native \
    ament-cmake-export-definitions-native \
    ament-cmake-export-dependencies-native \
    ament-cmake-export-include-directories-native \
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

ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'rosidl-typesupport-connext-cpp', '', d)}"
ROS_BUILD_DEPENDS:remove = "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opensplice', 'rosidl-typesupport-opensplice-cpp', '', d)}"

DEPENDS += "rosidl-cmake"
