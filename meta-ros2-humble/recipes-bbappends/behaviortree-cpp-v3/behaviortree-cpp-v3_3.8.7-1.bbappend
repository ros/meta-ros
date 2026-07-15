# Copyright (c) 2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    ament-cmake-gtest \
    googletest \
    cppzmq \
"

EXTRA_OECMAKE += "-DBUILD_UNIT_TESTS=OFF"
