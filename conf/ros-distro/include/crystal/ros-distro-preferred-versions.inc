# crystal/ros-distro-preferred-versions.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# Set PREFERRED_VERSION_<PN> here for non-platform packages for which the layers provide multiple versions and to override those
# set in ros-distro-platform-preferred-versions.inc .

# console-bridge-vendor expects this version (or it will build it itself):
PREFERRED_VERSION_console-bridge = "0.4.2"
