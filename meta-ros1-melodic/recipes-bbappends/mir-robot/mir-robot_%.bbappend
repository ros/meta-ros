# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[mir-robot] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'gazebo'], 'Requires mir-gazebo which depends on rqt-robot-steering which depends on python-qt-binding which requires meta-qt5 to be included and rdepends on mir-driver, mir-navigation, mir-description which require gazebo', '', d)}"
