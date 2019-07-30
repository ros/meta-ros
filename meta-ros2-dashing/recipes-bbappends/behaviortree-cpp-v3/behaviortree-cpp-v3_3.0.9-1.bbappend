# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    ament-cmake-gtest \
    cppzmq \
"

# OpenEmbedded will automatically add the dependency on the elfutils package that contains libdw.so .
ROS_EXEC_DEPENDS_remove = "elfutils"
