# Copyright (c) 2020 LG Electronics, Inc.

# ROS2 is python3-only and python2 is blacklisted here
ROS_BUILD_DEPENDS_remove = "python-catkin-pkg"
ROS_BUILD_DEPENDS_append = " python3-catkin-pkg"
