# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[fiducials] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-deps', 'depends on aruco-detect which depends on unavailable UNRESOLVED-python-cairosvg and UNRESOLVED-python-joblib', '', d)}"
