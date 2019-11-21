# foxy/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2020 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Foxy Fitzroy"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-focal"

require conf/ros-distro/include/foxy/generated/superflore-datetime.inc
require conf/ros-distro/include/foxy/generated/superflore-ros-distro.inc
require conf/ros-distro/include/foxy/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/foxy/ros-distro-preferred-versions.inc
require conf/ros-distro/include/foxy/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.
