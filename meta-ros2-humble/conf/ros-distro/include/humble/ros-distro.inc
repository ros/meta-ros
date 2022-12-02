# humble/ros-distro.inc
# General configuration settings that are dependent on ROS_DISTRO.
#
# Copyright (c) 2020-2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

ROS_DISTRO_CODENAME = "Humble Hawksbill"

ROS2_DISTRO = "humble"

# The platform release that the metadata for this ROS distro targets. This determines the versions of the platform packages that
# OE must provide. It must be one of the values of ROS_DISTRO_RELEASE_PLATFORMS (which is set in
# generated/superflore-ros-distro.inc).
ROS_DISTRO_BASELINE_PLATFORM = "ubuntu-jammy"

require conf/ros-distro/include/humble/generated/superflore-datetime.inc
require conf/ros-distro/include/humble/generated/superflore-ros-distro.inc
require conf/ros-distro/include/humble/ros-distro-recipe-blacklist.inc
require conf/ros-distro/include/humble/ros-distro-preferred-versions.inc
require conf/ros-distro/include/humble/ros-distro-preferred-providers.inc

# Override settings from generated/superflore-ros-distro.inc here.

# Since superflore doesn't know when it's generating a recipe that it will be for a build tool, it can't know that what's in
# ROS_EXEC_DEPEND are also build tools. Manually add them here.
ROS_SUPERFLORE_GENERATED_BUILDTOOLS += " \
    ament-lint-native \
    cyclonedds-native \
    domain-coordinator-native \
    foonathan-memory-vendor-native \
    iceoryx-binding-c-native \
    iceoryx-posh-native \
    iceoryx-utils-native \
    rcutils-native \
    rcpputils-native \
    rmw-dds-common-native \
    rmw-fastrtps-cpp-native \
    rmw-fastrtps-shared-cpp-native \
    rmw-native \
    rosidl-adapter-native \
    rosidl-cli-native \
    rosidl-default-runtime-native \
    rosidl-parser-native \
    rosidl-typesupport-fastrtps-c-native \
    rpyutils-native \
    uncrustify-vendor-native \
"

# this needs google-benchmark-vendor-native but we probably don't need native version
ROS_SUPERFLORE_GENERATED_BUILDTOOLS:remove = "ament-cmake-google-benchmark-native"

# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "connext"
# alternative not yet supported implementation for fastrtps
ROS_WORLD_SKIP_GROUPS += "opensplice"
# alternative not yet supported implementation for fastrtps, there is no recipe for gurumdds-2.6
ROS_WORLD_SKIP_GROUPS += "gurumdds"
# Can't build these until we figure out how to build clang-format, clang-tidy without building all of clang.
ROS_WORLD_SKIP_GROUPS += "clang"
# recipes depending on openni (libopenni-dev)
ROS_WORLD_SKIP_GROUPS += "openni"
# recipes depending on turtlebot3 specific recipes which weren't ported to eloquent yet
ROS_WORLD_SKIP_GROUPS += "turtlebot3"
# recipes depending on coinor-libipopt
ROS_WORLD_SKIP_GROUPS += "coinor-libipopt"
# Needs work to launch qemu to run tests on image on build machine.
ROS_WORLD_SKIP_GROUPS += "launch"
# recipes depending on ROS_UNRESOLVED_DEP-python3-babeltrace which cannot be just
# set to babeltrace, because python bindings in babeltrace are not enabled as shown in log.do_configure:
# configure: You may configure with --enable-python-bindings if you want Python bindings.
ROS_WORLD_SKIP_GROUPS += "babeltrace-python"
# recipes depends on cwiid
ROS_WORLD_SKIP_GROUPS += "cwiid"
# recipes depends on libspnav
ROS_WORLD_SKIP_GROUPS += "libspnav"

# recipes depending on 'x11' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'x11', d)}"
# recipes depending on 'opengl' in DISTRO_FEATURES
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', '', 'opengl', d)}"
# recipes depending on 'ffmpeg' which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'ffmpeg', 'commercial_ffmpeg'], '', 'ffmpeg', d)}"
# recipes depending on 'x264' (ffmpeg does depend on it by default as well) which is restricted by 'commercial' LICENSE_FLAG
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains_any('LICENSE_FLAGS_WHITELIST', ['commercial', 'x264', 'commercial_x264'], '', 'x264', d)}"
# There is recipe for glfw in meta-oe in dunfell, but it still needs x11 in DISTRO_FEATURES
# use that in dunfell and blacklist explicitly in older releases
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', '', 'glfw', d)}"

# webots recipes depending on unavailable python moules like:
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python-transforms3d-pip' (but meta-ros2-humble/generated-recipes/webots-ros2-desktop/webots-ros2-core_0.0.3-1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-urdf2webots-pip' (but meta-ros2-humble/generated-recipes/webots-ros2-desktop/webots-ros2-importer_0.0.3-1.bb RDEPENDS on or otherwise requires it)
# ERROR: Nothing RPROVIDES 'ROS_UNRESOLVED_DEP-python3-collada-pip' (but meta-ros2-humble/generated-recipes/webots-ros2-desktop/webots-ros2-importer_0.0.3-1.bb RDEPENDS on or otherwise requires it)
ROS_WORLD_SKIP_GROUPS += "webots-python-modules"

# ERROR: Nothing PROVIDES 'ROS_UNRESOLVED_DEP-sdformat' (but /jenkins/mjansa/build/ros/webos-humble-hardknott/meta-ros/meta-ros2-humble/generated-recipes/sdformat-urdf/sdformat-urdf_0.1.0-1.bb DEPENDS on or otherwise requires it)
ROS_WORLD_SKIP_GROUPS += "sdformat"

# recipes depending on gazebo, for which there is no OE recipe
ROS_WORLD_SKIP_GROUPS += "gazebo"

# not compatible with glibc-2.34 without easy fix as reported in https://github.com/ros2/demos/issues/530
ROS_WORLD_SKIP_GROUPS += "pendulum-control"

# recipes depending on libqglviewer (https://packages.debian.org/source/stretch/libqglviewer https://packages.debian.org/stretch/libqglviewer2-qt5)
ROS_WORLD_SKIP_GROUPS += "libqglviewer"

# recipes depending on ignition-* (ROS_UNRESOLVED_DEP-ignition-gazebo5, ROS_UNRESOLVED_DEP-ignition-math6, ROS_UNRESOLVED_DEP-ignition-msgs7, ROS_UNRESOLVED_DEP-ignition-transport10, ROS_UNRESOLVED_DEP-ignition-rendering5, ROS_UNRESOLVED_DEP-ignition-common4, ROS_UNRESOLVED_DEP-ignition-gui5)
ROS_WORLD_SKIP_GROUPS += "ignition"

# recipes depending on unavailable python3-shapely
ROS_WORLD_SKIP_GROUPS += "python3-shapely"
# recipes depending on unavailable python3-flask-cors
ROS_WORLD_SKIP_GROUPS += "python3-flask-cors"

# recipes depending on legacy mongo-cxx-driver (https://packages.debian.org/source/stretch/mongo-cxx-driver-legacy)
# the mongodb recipe in meta-oe installs just the binaries mongoc, mongos, install_compass
# the header files searched by mongo-store, warehouse-ros-mongo cmake files cmake/FindMongoClient.cmake and cmake/FindMongoDB.cmake
# aren't even part of current version of mongo-cxx-driver
# src/mongo/client/dbclient.h and src/mongo/client/dbclientinterface.h are only in the legacy branches
ROS_WORLD_SKIP_GROUPS += "mongodb-legacy-cxx-driver"

# Still depends on catkin-native, missing the update to ROS2 like dashing version got in https://github.com/ros-visualization/rqt_runtime_monitor/pull/5
ROS_WORLD_SKIP_GROUPS += "rqt-runtime-monitor"

# recipes depending on ros1
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'ros1-layer', '', 'ros1', d)}"

# recipes depending on something from meta-qt5 layer
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'qt5', d)}"

# recipes depending on libomp which could be provided by openmp@meta-clang
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'clang-layer', '', 'libomp', d)}"

# recipes depending on clang which could be provided by clang@meta-clang
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'clang-layer', '', 'clang', d)}"

# recipes depending on cargo which could be provided by cargo@meta-rust or oe-core[honister] and newer release (where it was imported from meta-rust)
ROS_WORLD_SKIP_GROUPS += "${@bb.utils.contains('BBFILE_COLLECTIONS', 'rust-layer', '', 'cargo', d)}"

# swri recipes depending on marti-*-msgs, currently broken after to https://github.com/ros/rosdistro/commit/e019cc8729e7ff2ba2ed51e63886734936254111
ROS_WORLD_SKIP_GROUPS += "swri"

# do_configure failures
ROS_WORLD_SKIP_GROUPS += " \
    lanelet2-traffic-rules \
    lanelet2-io \
"

# do_compile failures
ROS_WORLD_SKIP_GROUPS += " \
    lanelet2-core \
    qt-gui-cpp \
    self-test \
"

# Must use a _pn- override in this file to override the ROS_BUILD_TYPE of a generated recipe,
# because we need to set this variable before the "inherit" line in the recipe is parsed,
# and having it in a .bbappend sets it too late.
# We want ament_cmake instead of plain cmake for ros-workspace:
# https://raw.github.com/ros2-gbp/ros_workspace-release/release/humble/ros_workspace/1.0.1-2/package.xml
ROS_BUILD_TYPE:pn-ros-workspace = "ament_cmake"
# And also for rmf-task, otherwise many dependencies won't be detected
ROS_BUILD_TYPE:pn-rmf-task = "ament_cmake"

# Used by generated-recipes/cyclonedds/cyclonedds_0.6.0-3.bb
ROS_UNRESOLVED_DEP-java-native = ""
ROS_UNRESOLVED_DEP-maven-native = ""

# https://layers.openembedded.org/layerindex/recipe/45261/
ROS_UNRESOLVED_DEP-sqlite3 = "sqlite3"
