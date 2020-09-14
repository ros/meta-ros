# Copyright (c) 2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    ament-cmake-gtest \
    cppzmq \
"

FILES_${PN}-dev += "${libdir}/BehaviorTreeV3/cmake"
