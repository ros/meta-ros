# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

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

# ERROR: image-geometry-3.0.3-2-r0 do_package: QA Issue: image-geometry: Files/directories were installed but not shipped in any package:
#
do_install:append:class-target() {
    mkdir -p ${D}/usr/lib/python3.9/site-packages/
    mv ${D}${STAGING_DIR_NATIVE}/usr/lib/python3.9/site-packages/${ROS_BPN}* ${D}/usr/lib/python3.9/site-packages/
    rm -r ${D}/home
}