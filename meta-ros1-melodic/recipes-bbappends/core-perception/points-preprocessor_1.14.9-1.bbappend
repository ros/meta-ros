# Copyright (c) 2020 LG Electronics, Inc.

# gtest is PROVIDED by googletest recipe, but there is no gtest package RPROVIDED by that
ROS_EXEC_DEPENDS_remove = "gtest"
ROS_EXEC_DEPENDS_append = " googletest"
