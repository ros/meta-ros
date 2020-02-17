# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[aruco-detect] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'python-deps', 'Depends on unavailable UNRESOLVED-python-cairosvg and UNRESOLVED-python-joblib', '', d)}"
