# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rviz-default-plugins] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'x11'], 'qt5: depends on qtbase; x11: depends on rviz-ogre-vendor->(libx11,libxrandr,libxaw) which require x11 in DISTRO_FEATURES', '', d)}"
