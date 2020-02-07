# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[kobuki-ftdi] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'kobuki-ftdi', 'kobuki-ftdi: Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3', '', d)}"
