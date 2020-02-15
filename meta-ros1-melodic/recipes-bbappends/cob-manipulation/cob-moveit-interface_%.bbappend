# Copyright (c) 2019-2020 LG Electronics, Inc.

PNBLACKLIST[cob-moveit-interface] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'multimedia'], 'Depends on moveit-commander->moveit-ros-planning-interface->moveit-ros-planning->moveit-ros-perception->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES and depends on cob-script-server which requires cob-mimic, cob-sound which depends on vlc which requires meta-multimedia to be included', '', d)}"
