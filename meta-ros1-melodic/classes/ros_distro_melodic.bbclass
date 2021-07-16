# Every ROS recipe, generated or not, must contain "inherit ros_distro_${ROS_DISTRO}".
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO = "melodic"

inherit ${ROS_DISTRO_TYPE}_distro

# HACK until "python-qt-binding" builds
ROS_EXEC_DEPENDS:remove = "python-qt-binding"
