# Copyright (c) 2025 Wind River Systems, Inc.

# ROS_TEST_DEPENDS is present in the generated recipe but not used in OE
# osrf-testing-tools-cpp is a build dependency so add it explicitly 
ROS_BUILD_DEPENDS += "osrf-testing-tools-cpp"
