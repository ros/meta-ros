# Copyright (c) 2019 LG Electronics, Inc.

# Depends on pr2-moveit-config->moveit-ros-move-group->moveit-ros-planning->moveit-ros-perception->mesa with this restriction:
inherit distro_features_check
ANY_OF_DISTRO_FEATURES = "opengl vulkan"
