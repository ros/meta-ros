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

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    domain-coordinator-native \
    rcpputils-native \
    rmw-native \
    rosidl-adapter-native \
    rosidl-parser-native \
    uncrustify-vendor-native \
"

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
ROS_WORLD_SKIP_GROUPS += "clang"

# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"

# XXX Temp until superflore fixed.
# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
ROS_BUILD_TYPE_pn-fmilibrary-vendor = "ament_cmake"

# Used by:
# generated-recipes/spdlog-vendor/spdlog-vendor_1.1.1-1.bb
# generated-recipes/rcl-logging/rcl-logging-spdlog_0.4.0-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_spdlog = "spdlog"

# Used by:
# generated-recipes/ament-lint/ament-mypy_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-mypy = "python3-mypy"

# Used by:
# generated-recipes/ament-lint/ament-pycodestyle_0.9.1-1.bb
ROS_UNRESOLVED_PLATFORM_PKG_python3-pycodestyle = "python3-pycodestyle"
