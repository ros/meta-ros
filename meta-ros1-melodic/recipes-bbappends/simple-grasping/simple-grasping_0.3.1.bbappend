# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[simple-grasping] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyassimp'], 'Requires libvtk-qt which is not available and depends on moveit-python which depends on unavailable UNRESOLVED-python-pyassimp', '', d)}"
