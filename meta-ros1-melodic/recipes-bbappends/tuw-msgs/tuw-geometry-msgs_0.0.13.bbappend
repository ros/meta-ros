# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# tuw-geometry-msgs/0.0.13-r0/git/src/pose.cpp:62:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
