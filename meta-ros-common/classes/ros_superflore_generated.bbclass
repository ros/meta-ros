# Inherited by every recipe that superflore generates.
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_SUPERFLORE_GENERATED = "1"

# If superflore found this BPN listed as a build tool, extend the recipe to build BPN-native.
BBCLASSEXTEND_append = "${@bb.utils.contains('ROS_SUPERFLORE_GENERATED_BUILDTOOLS', '${BPN}-native', ' native', '', d)}"

# Returns under which of the includes-{ros1,ros2} trees the .inc files for packages of <component> should be placed.
# ROS1_COMPONENTS is set in conf/ros-distro/ros-distro.conf .
def ros_superflore_generated__get_includes_tree(component, d):
    return bb.utils.contains('ROS1_COMPONENTS', component, 'includes-ros1', 'includes-ros2', d)
