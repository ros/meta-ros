# Copyright (c) 2019-2020 LG Electronics, Inc.

# All rviz recipes aren't available without qtbase
ROS_EXEC_DEPENDS_remove = "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5', 'ogre'], 'nav2-rviz-plugins', '', d)}"
