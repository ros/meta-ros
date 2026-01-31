# jazzy/ros-distro-preferred-versions.inc
#
# Copyright (c) 2020 LG Electronics, Inc.

# Set PREFERRED_VERSION_<PN> here for non-platform packages for which the layers provide multiple versions and to override those
# set in ros-distro-platform-preferred-versions.inc .

# REP-0003 specifies 1.10.1 for noetic
# REP-2000 specifies 1.12.1 for humble and iron and 1.13.0 for jazzy
# This is necessary as with ROS1 many recipes fail to build
# as documented in https://github.com/ros/meta-ros/pull/936
PREFERRED_VERSION_pcl = "1.13.0"

PREFERRED_VERSION_sdformat = "14.8.0"

PREFERRED_VERSION_dartsim = "6.13.2"

PREFERRED_VERSION_ogre-next = "2.3.3"

PREFERRED_VERSION_gz-cmake3 = "3.5.5"
PREFERRED_VERSION_gz-common5 = "5.7.1"
PREFERRED_VERSION_gz-fuel_tools9 = "9.1.1"
PREFERRED_VERSION_gz-gui8 = "8.4.0"
PREFERRED_VERSION_gz-launch7 = "7.1.1"
PREFERRED_VERSION_gz-math7 = "7.5.2"
PREFERRED_VERSION_gz-msgs10 = "10.3.2"
PREFERRED_VERSION_gz-physics7 = "7.6.0"
PREFERRED_VERSION_gz-plugin2 = "2.0.4"
PREFERRED_VERSION_gz-rendering8 = "8.2.3"
PREFERRED_VERSION_gz-sensors8 = "8.2.2"
PREFERRED_VERSION_gz-sim8 = "8.9.0"
PREFERRED_VERSION_gz-tools2 = "2.0.2"
PREFERRED_VERSION_gz-transport13 = "13.5.0"
PREFERRED_VERSION_gz-utils2 = "2.2.1"
