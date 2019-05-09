# packagegroup-ros-world-crystal.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# Can't build these until we figure out how to build clang-format without building all of clang.
RDEPENDS_${PN}_remove = "ament-clang-format"
RDEPENDS_${PN}_remove = "ament-cmake-clang-format"

# Not used by "crystal"; this allows us to defer fixing log4cxx v0.10.0-13 until working on "melodic".
RDEPENDS_${PN}_remove = "rcl-logging-log4cxx"
