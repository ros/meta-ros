# Every ROS recipe, generated or not, must contain "inherit ros_distro_${ROS_DISTRO}".
#
# Copyright (c) 2020 LG Electronics, Inc.

ROS_DISTRO = "noetic"

inherit ${ROS_DISTRO_TYPE}_distro

# HACK until "python-qt-binding" builds
ROS_EXEC_DEPENDS:remove = "python-qt-binding"
