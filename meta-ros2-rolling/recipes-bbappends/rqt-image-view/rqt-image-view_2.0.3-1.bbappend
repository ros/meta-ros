# Copyright (c) 2023-2026 Wind River Systems, Inc.

LICENSE = "BSD-3-Clause"

ROS_BUILDTOOL_DEPENDS += "\
    rosidl-default-generators-native \
"

# CMake Warning at rqt-image-view/1.2.0-2-r0/recipe-sysroot/usr/lib/cmake/Qt5Widgets/Qt5WidgetsConfig.cmake:6 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
# CMake Error at CMakeLists.txt:49 (qt5_wrap_cpp):
#   Unknown CMake command "qt5_wrap_cpp".
inherit ${@bb.utils.contains('BBFILE_COLLECTIONS', 'qt6-layer', 'qt6-cmake', '', d)}

ROS_BRANCH = "branch=ahcorde/rolling/support_qt6"
SRC_URI = "git://github.com/ros-visualization/rqt_image_view.git;${ROS_BRANCH};protocol=https"
SRCREV = "707acf8c87c43e094f0119ac72ae6e2592bd96eb"
