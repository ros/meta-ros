# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[visualization-osg] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'osg', 'depends on osg-markers, osg-utils, osg-interactive-markers which depend on unavailable UNRESOLVED-libopenscenegraph', '', d)}"
