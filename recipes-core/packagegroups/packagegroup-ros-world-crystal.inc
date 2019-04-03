# packagegroup-ros-world-crystal.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# Can't build these until we figure out how to build clang-format without building all of clang.
RDEPENDS_${PN}_remove = "ament-clang-format"
RDEPENDS_${PN}_remove = "ament-cmake-clang-format"

# Not used by "crystal"; this allows us to defer fixing log4cxx v0.10.0-13 until working on "melodic".
RDEPENDS_${PN}_remove = "rcl-logging-log4cxx"

# OE won't let us build ffmpeg unless LICENSE_FLAGS_WHITELIST contains "commerical".
RDEPENDS_${PN}_remove = "${@bb.utils.contains('LICENSE_FLAGS_WHITELIST', 'commercial', '', 'ffmpeg', d)}"

# RViz requires the "opengl" distro feature.
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'object-analytics-rviz', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-assimp-vendor', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-common', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-default-plugins', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-ogre-vendor', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-rendering', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-rendering-tests', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz-visual-testing-framework', d)}"
RDEPENDS_${PN}_remove = "${@bb.utils.contains('DISTRO_FEATURES', 'ros-rviz opengl', '', 'rviz2', d)}"
