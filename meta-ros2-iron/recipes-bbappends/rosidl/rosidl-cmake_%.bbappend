# Copyright (c) 2022 Acceleration Robotics, S.L.

inherit setuptools3-base

ROS_BUILD_DEPENDS += " \
    ament-cmake-test \
"

ROS_BUILDTOOL_EXPORT_DEPENDS:append = " \
    ament-cmake-test-native \
"
