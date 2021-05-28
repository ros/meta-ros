# Copyright (c) 2021 LG Electronics, Inc.

EXTRA_OECMAKE += "-Dros_industrial_cmake_boilerplate_DIR=${STAGING_LIBDIR}/cmake/ros_industrial_cmake_boilerplate"

# it's only in ROS_TEST_DEPENDS and we have testing disabled. CMake tries to find it even with testing disabled.
DEPENDS += "tesseract-support"
