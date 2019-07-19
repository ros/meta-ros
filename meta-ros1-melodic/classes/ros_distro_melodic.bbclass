# Every ROS recipe, generated or not, must contain "inherit ros_distro_${ROS_DISTRO}".
#
# Copyright (c) 2019 LG Electronics, Inc.

ROS_DISTRO = "melodic"

require conf/ros-distro/include/${ROS_DISTRO}/generated/ros-distro.inc
require conf/ros-distro/include/${ROS_DISTRO}/ros-distro.inc

inherit ${ROS_DISTRO_TYPE}_distro

# If not using Qt, drop all RDEPENDS on "python-qt-binding".
#ROS_EXEC_DEPENDS_remove = "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'python-qt-binding', d)}"
# XXX TEMP until "python-qt-binding" builds
ROS_EXEC_DEPENDS_remove = "python-qt-binding"
