# Copyright (c) 2021 LG Electronics, Inc.

# tf2-kdl is only in ROS_TEST_DEPENDS but CMake checks for it even with testing disabled
DEPENDS += "\
    tf2-kdl \
    pluginlib \
"
