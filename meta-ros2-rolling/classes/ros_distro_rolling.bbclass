# Every ROS recipe, generated or not, must contain "inherit ros_distro_${ROS_DISTRO}".
#
# Copyright (c) 2020 LG Electronics, Inc.

ROS_DISTRO = "rolling"

inherit ${ROS_DISTRO_TYPE}_distro

# Since nanbield, pkgconfig no longer a default include. But it is needed
# by a lot of packages within ROS. So we add it here.

DEPENDS:prepend = " \
    pkgconfig-native \
"