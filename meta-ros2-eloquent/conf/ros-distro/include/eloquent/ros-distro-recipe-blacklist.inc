# eloquent/ros-distro-recipe-blacklist.inc
#
# Copyright (c) 2019-2020 LG Electronics, Inc.

# This is a ROS 2 distro, so blacklist ROS 1 packages that will never be ROS 2.
PNBLACKLIST[packagegroup-ros1-comm] ?= "Not a ROS 2 package"
PNBLACKLIST[packagegroup-ros1-industrial] ?= "Not a ROS 2 package"
PNBLACKLIST[packagegroup-ros1-kobuki] ?= "Not a ROS 2 package"

# Initially, blacklist any non-platform duplicates found by "bitbake-layers show-overlayed". Remove from the blacklist once a
# PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)

# Initially, blacklist any non-platform recipes with multiple versions found by "bitbake-layers show-recipes --multiple". Remove
# from the blacklist once a PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)

# Others
PNBLACKLIST[libyaml] ?= "Provided by libyaml-vendor"
