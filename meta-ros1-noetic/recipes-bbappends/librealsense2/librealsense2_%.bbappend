# Copyright (c) 2020 LG Electronics, Inc.

# virtual/kernel is only for build time dependencies
ROS_EXEC_DEPENDS_remove = "virtual/kernel"

# building internal version of glfw fails when cross-compiling
# make it depend on glfw (3.3 and newer like ROS2 librealsense2 does)
DEPENDS += "glfw"
