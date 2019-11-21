# foxy/ros-distro-recipe-blacklist.inc
#
# Copyright (c) 2020 LG Electronics, Inc.

# Initially, blacklist any non-platform duplicates found by "bitbake-layers show-overlayed". Remove from the blacklist once a
# PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)

# Initially, blacklist any non-platform recipes with multiple versions found by "bitbake-layers show-recipes --multiple". Remove
# from the blacklist once a PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)
