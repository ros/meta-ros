# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[rqt-common-plugins] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'python3-matplotlib'], 'qt5: depends on (rqt-action,rqt-console,rqt-graph,rqt-shell,rqt-plot,rqt-publisher->python-qt-binding->qtbase; python3-matplotlib: depends on rqt-plot->python3-matplotlib which is not available', '', d)}"
