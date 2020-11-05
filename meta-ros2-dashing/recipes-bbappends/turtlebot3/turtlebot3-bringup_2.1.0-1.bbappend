# Copyright (c) 2020 LG Electronics, Inc.

ROS_EXEC_DEPENDS_remove = "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'x11'], 'rviz2', '', d)}"
