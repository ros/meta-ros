# Copyright (c) 2019 LG Electronics, Inc.

# Depends on moveit-commander->moveit-ros-planning-interface->moveit-ros-planning->moveit-ros-perception->mesa with this restriction:
inherit distro_features_check
ANY_OF_DISTRO_FEATURES = "opengl vulkan"
