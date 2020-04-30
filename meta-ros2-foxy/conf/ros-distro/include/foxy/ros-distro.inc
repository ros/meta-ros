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

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"

# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"

# Used by:
# generated-recipes/spdlog-vendor/spdlog-vendor_1.1.1-1.bb
# generated-recipes/rcl-logging/rcl-logging-spdlog_0.4.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_spdlog = "spdlog"

# Used by:
# generated-recipes/ament-lint/ament-mypy_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-mypy = "python3-mypy"
