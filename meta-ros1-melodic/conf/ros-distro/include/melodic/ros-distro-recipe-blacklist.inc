# medlodic/ros-distro-recipe-blacklist.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# This is a ROS 1 distro, so blacklist ROS 2 packages that will never be ROS 1.
PNBLACKLIST[packagegroup-ros2-demos] ?= "Not a ROS 1 package"
PNBLACKLIST[packagegroup-ros2-world] ?= "Not a ROS 1 package"

# Initially, blacklist any non-platform duplicates found by "bitbake-layers show-overlayed". Remove from the blacklist once a
# PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
PNBLACKLIST[libmodbus] ?= "Must specify PREFERRED_VERSION"

# Initially, blacklist any non-platform recipes with multiple versions found by "bitbake-layers show-recipes --multiple". Remove
# from the blacklist once a PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)
