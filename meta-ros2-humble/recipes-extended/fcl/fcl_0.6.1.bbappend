# Copyright (c) 2021 LG Electronics, Inc.

# Add dependency on foxy's octomap:
# meta-ros2-foxy/generated-recipes/octomap/octomap_1.9.5-2.bb
# it's not enabled as optional dependency on common recipe:
# meta-ros-common/recipes-extended/fcl/fcl_0.6.1.bb
# but moveit-core from foxy, needs octomap support to be enabled
DEPENDS += "octomap"
