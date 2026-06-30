# Copyright (c) 2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    ament-cmake-gtest \
    googletest \
    cppzmq \
"

FILES:${PN}-dev += "${libdir}/BehaviorTreeV3/cmake"
