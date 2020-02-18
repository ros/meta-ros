# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[mongodb-log] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'mongodb', 'Requires mongodb-store->mongodb', '', d)}"
