# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[turtlebot3-simulations] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'gazebo: depends on turtlebot3-gazebo->gazebo-ros-pkgs->gazebo-rosdev->gazebo which is not available', '', d)}"
