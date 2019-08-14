# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS += "suitesparse-cxsparse"

# Missing license version in package.xml maps it to invalid LGPL-2
# https://github.com/ros-perception/slam_karto/issues/28
LICENSE = "LGPL-3.0+ & CC-BY-2.0"
