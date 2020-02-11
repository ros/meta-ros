# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[smach-viewer] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'wxpython', 'Depends on wxpython which does not build: ld: cannot find -lwx_gtk3u_xrc-3.0', '', d)}"
