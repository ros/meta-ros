# Copyright (c) 2021 LG Electronics, Inc.
# Copyright (c) 2022 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS = " \
    ament-cmake-native \
    ament-cmake-auto-native \
    ament-cmake-ros-native \
    python3-numpy-native \
"

# Fails with webOS OSE which by default uses -Werror=return-type
# rplidar-ros/2.0.2-1-r0/git/sdk/src/rplidar_driver.cpp:2222:26: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
