# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[urdf-sim-tutorial] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires rviz which requires meta-qt5 to be included and rdepends on gazebo-ros-control which requires gazebo', '', d)}"
