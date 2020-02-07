# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[spatio-temporal-voxel-layer] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'openvdb-openexr', 'openvdb-openexr: Depends on openvdb and openexr for which we do not have recipes yet', '', d)}"
