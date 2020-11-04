# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# rplidar-ros/2.0.0-1-r0/git/sdk/src/rplidar_driver.cpp:2222:26: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
