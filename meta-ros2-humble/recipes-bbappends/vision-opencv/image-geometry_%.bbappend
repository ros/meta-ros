# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# Fix for Honister release only:
inherit distutils3-base

# |   Could not find a package configuration file provided by "rosidl_adapter"
# |   with any of the following names:
# |
# |     rosidl_adapterConfig.cmake
# |     rosidl_adapter-config.cmake
ROS_BUILD_DEPENDS:append = " rosidl-adapter"

# | CMake Error in CMakeLists.txt:
# |   Imported target "sensor_msgs::sensor_msgs__rosidl_generator_py" includes
# |   non-existent path
ROS_BUILD_DEPENDS += " \
    python3-numpy-native \
"
