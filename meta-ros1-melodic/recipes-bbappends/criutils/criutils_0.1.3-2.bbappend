# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[criutils] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-deps', 'Depends on unavailable UNRESOLVED-python-termcolor', '', d)}"
