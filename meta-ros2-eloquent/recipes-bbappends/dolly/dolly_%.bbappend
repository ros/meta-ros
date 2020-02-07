# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[dolly] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'gazebo: depends on dolly-gazebo->gazebo-ros-pkgs->gazebo-ros->gazebo-rosdev->gazebo which is not available', '', d)}"
