# Copyright (c) 2023 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

# Target "rqt_gui_cpp" links to target "Qt5::Widgets" but the target was not found.
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt6', 'pyqt6'], '', 'qt6-cmake', d)}
