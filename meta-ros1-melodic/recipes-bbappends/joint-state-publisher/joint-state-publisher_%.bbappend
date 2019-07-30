# Copyright (c) 2019 LG Electronics, Inc.

# Remove "python-qt-bindings" from RDEPENDS if the Qt5 layer is absent.
#ROS_EXEC_DEPENDS_remove = "${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt5-layer', '', 'python-qt-binding', d)}"

# XXX TEMP
ROS_EXEC_DEPENDS_remove = "python-qt-binding"
