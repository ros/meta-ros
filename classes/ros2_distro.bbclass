# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_distro

# Place metadata unique to ROS 2 distros here.

# ROS1_COMPONENTS is set in conf/ros-distro/ros-distro.conf .
def ros_distro__get_component_type(component, d):
    return bb.utils.contains('ROS1_COMPONENTS', component, 'ros1', 'ros2', d)

# https://index.ros.org/doc/ros2/Installation/Linux-Development-Setup/#id3 says LANG must be in the environment. Allow it to be
# overridden in local.conf . (Can't place in conf/layer.conf as it causes do_patch() to fail when building linux-raspberrypi.)
export LANG ??= "en_US.UTF-8"

# *.cmake files have hardcoded sysroot-s in them.
SSTATE_SCAN_FILES_append = " *.cmake"
