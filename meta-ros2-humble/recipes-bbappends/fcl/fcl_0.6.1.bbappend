# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

# Add dependency on humble's octomap:
# meta-ros2-humble/generated-recipes/octomap/octomap_1.9.8-1.bb
# it's not enabled as optional dependency on common recipe:
# meta-ros-common/recipes-extended/fcl/fcl_0.6.1.bb
# but moveit-core from humble, needs octomap support to be enabled
DEPENDS += "octomap"
