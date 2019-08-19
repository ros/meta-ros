# Every ROS recipe, generated or not, must contain "inherit ros_distro_${ROS_DISTRO}".
#
# Copyright (c) 2019 LG Electronics, Inc.

inherit ${ROS_DISTRO_TYPE}_distro

# If not using Qt, drop all RDEPENDS on "python-qt-binding".
ROS_EXEC_DEPENDS_remove = "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'python-qt-binding', d)}"
