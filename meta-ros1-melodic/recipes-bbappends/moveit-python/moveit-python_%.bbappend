# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[moveit-python] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'pyassimp', 'Depends on UNRESOLVED-python-pyassimp', '', d)}"
