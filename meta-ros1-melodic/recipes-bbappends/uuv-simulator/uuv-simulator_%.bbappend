# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[uuv-simulator] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'gazebo', 'Depends on gazebo, uuv-descriptions, uuv-gazebo-plugins, uuv-gazebo-ros-plugins, uuv-gazebo-worlds, uuv-sensor-ros-plugins, uuv-world-plugins, uuv-world-ros-plugins which is not available', '', d)}"
