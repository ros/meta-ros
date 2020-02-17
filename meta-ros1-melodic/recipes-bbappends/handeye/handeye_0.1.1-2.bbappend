# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[handeye] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-deps', 'Depends on criutils which depends on unavailable UNRESOLVED-python-termcolor', '', d)}"
