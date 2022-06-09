# Copyright (c) 2022 Acceleration Robotics, S.L.

# Fix for Honister release only:
inherit distutils3-base

ROS_BUILD_DEPENDS += " \
    ament-cmake-test \
"

ROS_BUILDTOOL_EXPORT_DEPENDS:append = " \
    ament-cmake-test-native \
"
