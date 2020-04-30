# foxy/ros-distro-recipe-blacklist.inc
#
# Copyright (c) 2020 LG Electronics, Inc.

# Initially, blacklist any non-platform duplicates found by "bitbake-layers show-overlayed". Remove from the blacklist once a
# PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)

# Initially, blacklist any non-platform recipes with multiple versions found by "bitbake-layers show-recipes --multiple". Remove
# from the blacklist once a PREFERRED_VERSION_<PN> setting is made in ros-distro-preferred-versions.inc .
# (none)

PNBLACKLIST[connext-cmake-module-native] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds-native which is not available', '', d)}"
PNBLACKLIST[connext-cmake-module] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds which is not available', '', d)}"
PNBLACKLIST[librealsense2] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'glfw'], 'opengl: depends on mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES; glfw: Depends on glfw which is not available in zeus and older', '', d)}"
PNBLACKLIST[rmw-connext-cpp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds which is not available', '', d)}"
PNBLACKLIST[rmw-connext-shared-cpp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds which is not available', '', d)}"
PNBLACKLIST[rosidl-typesupport-connext-c] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on (rosidl-typesupport-connext-cpp-native,connext-cmake-module-native)->rti-connext-dds-native which is not available', '', d)}"
PNBLACKLIST[rosidl-typesupport-connext-cpp-native] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds-native which is not available', '', d)}"
PNBLACKLIST[rosidl-typesupport-connext-cpp] ?= "${@bb.utils.contains('ROS_WORLD_SKIP_GROUPS', 'connext', 'connext: depends on rti-connext-dds-native which is not available', '', d)}"
