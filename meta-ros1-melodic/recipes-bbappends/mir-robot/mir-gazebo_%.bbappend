# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[mir-gazebo] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires rqt-robot-steering which depends on python-qt-binding which requires meta-qt5 to be included and rdepends on mir-driver, mir-description, gazebo-ros which require gazebo', '', d)}"
