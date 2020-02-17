# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[uwsim] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'opengl', 'Depends on mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES', 'depends on osg-utils, osg-markers, osg-interactive-markers which depends on unavailable UNRESOLVED-libopenscenegraph', d)}"
