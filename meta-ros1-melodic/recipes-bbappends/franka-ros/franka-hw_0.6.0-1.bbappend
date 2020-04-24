# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# franka-hw/0.6.0-1-r0/git/src/franka_hw.cpp:25:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
