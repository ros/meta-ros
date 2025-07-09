# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    rosidl-default-generators-native \
    ament-cmake-ros-native \
    ament-cmake-core-native \
    ament-package-native \
"

EXTRA_OECMAKE += " --debug-find "
inherit pkgconfig
