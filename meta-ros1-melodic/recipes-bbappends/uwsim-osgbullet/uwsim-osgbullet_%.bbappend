# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[uwsim-osgbullet] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'osg'], 'Depends on uwsim-osgworks->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and depends on unavailable UNRESOLVED-libopenscenegraph', '', d)}"
