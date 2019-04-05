# Copyright (c) 2019 LG Electronics, Inc.

# sros2-cmake is a ament dependent package but package.xml has 'cmake' as build_type.
ROS_BUILD_TYPE = "ament_cmake"
ROS_BUILDTOOL_DEPENDS += " \
    ament-cmake-core-native \
    ament-package-native \
"
