# Copyright (c) 2023 Wind River Systems, Inc.

# CMake Warning at nav2-rviz-plugins/1.1.12-1-r0/recipe-sysroot/usr/lib/cmake/Qt5/Qt5Config.cmake:7 (message):
#   SkippingbecauseOE_QMAKE_PATH_EXTERNAL_HOST_BINSisnotdefined
inherit ${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['qt5', 'qt5-widgets'], '', 'cmake_qt5', d)}

# OgreAlignedAllocator.h:108:73: error: extra ';' [-Werror=pedantic]
CXXFLAGS += "-Wno-error=pedantic"

# OgreMaterialManager.h:118:80: error: unused parameter 'technique' [-Werror=unused-parameter]
CXXFLAGS += "-Wno-error=unused-parameter"
