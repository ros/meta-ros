# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics, S.L.

# Fix for Honister release only:
inherit distutils3-base

ROS_BUILD_DEPENDS:remove = "ament-cmake"
ROS_BUILDTOOL_DEPENDS += "ament-cmake-native"

ROS_BUILD_DEPENDS += " \
    ament-cmake-test \
"
