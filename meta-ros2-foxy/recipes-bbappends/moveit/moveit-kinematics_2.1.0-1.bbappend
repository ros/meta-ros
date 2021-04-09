# Copyright (c) 2021 LG Electronics, Inc.

# moveit-ros-planning is in ROS_TEST_DEPENDS but CMake checks for that even
# when building with tests disabled
DEPENDS += "moveit-ros-planning"
