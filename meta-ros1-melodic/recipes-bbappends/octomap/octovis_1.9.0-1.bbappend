# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[octovis] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt4', 'It has dependencies on Qt4 packages; it is not used by any other ROS 1 package.', '', d)}"
