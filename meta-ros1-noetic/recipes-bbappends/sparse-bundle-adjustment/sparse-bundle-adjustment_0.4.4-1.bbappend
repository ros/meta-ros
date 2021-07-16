# Copyright (c) 2019 LG Electronics, Inc.

# this component doesn't need libblas at all
ROS_BUILD_DEPENDS:remove = "openblas"
ROS_EXPORT_DEPENDS:remove = "openblas"
ROS_EXEC_DEPENDS:remove = "openblas"
