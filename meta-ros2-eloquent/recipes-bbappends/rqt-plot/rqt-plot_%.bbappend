# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rqt-plot] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python3-matplotlib'], 'qt5: depends on (python-qt-binding,rqt-py-common)->qtbase; python3-matplotlib: depends on python3-matplotlib which is not available', '', d)}"
