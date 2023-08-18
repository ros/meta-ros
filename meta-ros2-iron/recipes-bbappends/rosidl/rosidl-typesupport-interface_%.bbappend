# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# | CMake Error at /home/xilinx/xilinx-k26-som-2022.1/build/tmp/work/cortexa72-cortexa53-xilinx-linux/ament-cmake-ros/0.10.0-3-r0/recipe-sysroot-native/usr/share/ament_cmake/cmake/ament_cmake_export_dependencies-extras.cmake:21 (find_package):
# |   By not providing "Findament_cmake_test.cmake" in CMAKE_MODULE_PATH this
# |   project has asked CMake to find a package configuration file provided by
# |   "ament_cmake_test", but CMake did not find one.
# |
# |   Could not find a package configuration file provided by "ament_cmake_test"
# |   with any of the following names:
# |
# |     ament_cmake_testConfig.cmake
# |     ament_cmake_test-config.cmake
# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    ament-cmake-test \
"
