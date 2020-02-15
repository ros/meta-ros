# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[simulators] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires rqt-robot-plugins which depends on rqt-rviz which depends on qtbase which requires meta-qt5 to be included and rdepends on gazebo-ros-pkgs which requires gazebo', '', d)}"
