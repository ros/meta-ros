# Copyright (c) 2021 LG Electronics, Inc.

require pcl.inc

PV = "1.11.0+git${SRCPV}"
SRCREV = "f9f214f34a38d5bb67441140703a681c5d299906"

# REP-2000 and REP-0003 specify 1.10 (for foxy, galactic, noetic) and 1.8 (for dashing, eloquent, melodic)
# 1.11 is compatible with all ROS2 distributions (only build tested), but with ROS1 many recipes fail to build
# as documented in https://github.com/ros/meta-ros/pull/936
DEFAULT_PREFERENCE = "-1"
