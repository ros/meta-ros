# kilted/ros-distro-preferred-versions.inc
#
# Copyright (c) 2020 LG Electronics, Inc.

# Set PREFERRED_VERSION_<PN> here for non-platform packages for which the layers provide multiple versions and to override those
# set in ros-distro-platform-preferred-versions.inc .

# REP-0003 specifies 1.10.1 for noetic
# REP-2000 specifies 1.12.1 for humble and iron
# REP-2000 specifies 1.14.0 for jazzy and kilted
# This is necessary as with ROS1 many recipes fail to build
# as documented in https://github.com/ros/meta-ros/pull/936
PREFERRED_VERSION_pcl = "1.14.1"

PREFERRED_VERSION_sdformat = "15.3.0"

# required for python3-scipy
PREFERRED_VERSION_python3-gast = "0.6.0"

PREFERRED_VERSION_dartsim = "6.13.2"

PREFERRED_VERSION_gz-cmake4 = "4.1.1"
PREFERRED_VERSION_gz-common6 = "6.1.0"
PREFERRED_VERSION_gz-fuel_tools10 = "10.1.0"
PREFERRED_VERSION_gz-gui9 = "9.0.1"
PREFERRED_VERSION_gz-launch8 = "8.0.1"
PREFERRED_VERSION_gz-math8 = "8.2.0"
PREFERRED_VERSION_gz-msgs11 = "11.1.0"
PREFERRED_VERSION_gz-physics8 = "8.3.0"
PREFERRED_VERSION_gz-plugin3 = "3.1.0"
PREFERRED_VERSION_gz-rendering9 = "9.4.0"
PREFERRED_VERSION_gz-sensors9 = "9.2.0"
PREFERRED_VERSION_gz-sim9 = "9.4.0"
PREFERRED_VERSION_gz-tools2 = "2.0.3"
PREFERRED_VERSION_gz-transport14 = "14.1.0"
PREFERRED_VERSION_gz-utils3 = "3.1.1"

PREFERRED_VERSION_ogre-next = "2.3.3"

# python-pygraphviz needed a version < 13
PREFERRED_VERSION_graphviz = "12.2.1"
