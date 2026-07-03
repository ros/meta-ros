# Copyright (c) 2020 LG Electronics, Inc.

# it's already in ROS_TEST_DEPENDS, but do_configure fails without
# it even when testing isn't enabled
DEPENDS += "rosidl-runtime-c"

# exported in rosidl_generator_c/cmake/ament_cmake_export_dependencies-extras.cmake
DEPENDS += "rosidl-cmake"
