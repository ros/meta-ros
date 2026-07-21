# Copyright (c) 2021 LG Electronics, Inc.

LICENSE = "BSD-3-Clause"

# Doesn't need runtime dependency on ceres-solver
ROS_EXEC_DEPENDS:remove = "ceres-solver"

# received_message_period.hpp:175:32: error: unused parameter 'message_info' [-Werror=unused-parameter]
CXXFLAGS += "-Wno-error=unused-parameter"
