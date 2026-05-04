# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2024 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"

# received_message_period.hpp:175:32: error: unused parameter 'message_info' [-Werror=unused-parameter]
CXXFLAGS += "-Wno-unused-parameter"
CXXFLAGS += "-Wno-deprecated-declarations"
CXXFLAGS += "-Wno-overloaded-virtual"
CXXFLAGS += "-Wno-unused-variable"

ROS_BUILD_DEPENDS:append = " \
    ament-cmake-ros-core-native \
"
