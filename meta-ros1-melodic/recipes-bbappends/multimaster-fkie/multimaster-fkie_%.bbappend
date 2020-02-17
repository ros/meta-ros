# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[multimaster-fkie] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'qt5', 'Requires node-manager-fkie which requires meta-qt5 to be included', 'depends on master-sync-fkie which dependsepends on master-discovery-fkie which depends on unavailable UNRESOLVED-python-avahi', d)}"
