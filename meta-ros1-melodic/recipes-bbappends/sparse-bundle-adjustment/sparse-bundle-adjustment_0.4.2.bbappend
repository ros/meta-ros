# Copyright (c) 2019 LG Electronics, Inc.

# this component doesn't need libblas at all
ROS_BUILD_DEPENDS_remove = "openblas"
ROS_EXPORT_DEPENDS_remove = "openblas"
ROS_EXEC_DEPENDS_remove = "openblas"
