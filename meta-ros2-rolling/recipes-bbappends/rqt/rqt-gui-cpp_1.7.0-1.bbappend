# Copyright (c) 2023 Wind River Systems, Inc.

# Target "rqt_gui_cpp" links to target "Qt5::Widgets" but the target was not found.
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'pyqt5'], '', 'cmake_qt5', d)}
