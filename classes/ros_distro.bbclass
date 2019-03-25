# Metadata common to all ROS distro types.
#
# Copyright (c) 2019 LG Electronics, Inc.

DISTROOVERRIDES .= ":${ROS_DISTRO_BASELINE_PLATFORM}:${ROS_DISTRO_TYPE}-distro:${ROS_DISTRO}:${ROS_COMPONENT_TYPE}-component"

# ros<N>_distro.bbclass must provide an implementation of ros_distro__get_component_type(component, d).
