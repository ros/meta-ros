# eloquent/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2019-2020 LG Electronics, Inc.

ROS_DISTRO_CODENAME = "Eloquent Elusor"

ROS2_DISTRO = "eloquent"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-bionic"

require conf/ros-distro/include/eloquent/generated/superflore-datetime.inc
require conf/ros-distro/include/eloquent/generated/superflore-ros-distro.inc
require conf/ros-distro/include/eloquent/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/eloquent/ros-distro-preferred-versions.inc
require conf/ros-distro/include/eloquent/ros-distro-preferred-providers.inc

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "opensplice"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
ROS_WORLD_SKIP_GROUPS += "clang"
# Depends on python3-docker which is available in meta-virtualization, but we don't want to add the
# dependency on this layer to meta-ros yet
ROS_WORLD_SKIP_GROUPS += "docker"
# Needs work to launch qemu to run tests on image on build machine.
ROS_WORLD_SKIP_GROUPS += "launch"
# recipes depending on turtlebot3 specific recipes which weren't ported to eloquent yet
ROS_WORLD_SKIP_GROUPS += "turtlebot3"
# recipes depending on ROS_UNRESOLVED_DEP-python3-babeltrace which cannot be just
# set to babeltrace, because python bindings in babeltrace are not enabled as shown in log.do_configure:
# configure: You may configure with --enable-python-bindings if you want Python bindings.
ROS_WORLD_SKIP_GROUPS += "babeltrace-python"
# recipes depending on python3-matplotlib
# there is python2 version in meta-ros-common/recipes-devtools/python/python-matplotlib_2.1.1.bb
# but no python3 version yet
ROS_WORLD_SKIP_GROUPS += "python3-matplotlib"
# recipes depending on coin-or libcbc for which we don't have recipes yet
ROS_WORLD_SKIP_GROUPS += "coin-or"
# recipes depending on coinor-libipopt
ROS_WORLD_SKIP_GROUPS += "coinor-libipopt"
# Not compatible with newer libftdi included in meta-oe: https://github.com/kobuki-base/kobuki_ftdi/issues/3
ROS_WORLD_SKIP_GROUPS += "kobuki-ftdi"
# recipes depending on openvdb and openexr for which we don't have recipes yet
ROS_WORLD_SKIP_GROUPS += "openvdb-openexr"
# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"
# recipes depending on something from meta-qt4 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt4-layer', '', 'qt4', d)}"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"

# recipes depending on python*-pyqt5 from meta-qt5 layer
# Use separate group, because e.g. webOS OSE has meta-qt5 layer included, but python*-pyqt5
# is blacklisted, because webOS OSE is missing newer meta-qt5 from warrior with older meta-oe thud which has
# incompatible old sip
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'pyqt5', d)}"

# do_configure failures
ROS_WORLD_SKIP_GROUPS += " \
    lanelet2-io \
    lanelet2-traffic-rules \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    rc-dynamics-api \
"

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    foonathan-memory-vendor-native \
    domain-coordinator-native \
    poco-vendor-native \
    rcpputils-native \
    rcutils-native \
    rmw-native \
    rmw-fastrtps-cpp-native \
    rmw-fastrtps-dynamic-cpp-native \
    rmw-fastrtps-shared-cpp-native \
    rmw-implementation-cmake-native \
    rmw-implementation-native \
    rosidl-actions-native \
    rosidl-adapter-native \
    rosidl-typesupport-fastrtps-c-native \
    uncrustify-vendor-native \
"

# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
# We want ament_cmake instead of plain cmake for ros-workspace:
# https://raw.github.com/ros2-gbp/ros_workspace-release/release/eloquent/ros_workspace/1.0.1-1/package.xml
ROS_BUILD_TYPE_pn-ros-workspace = "ament_cmake"
