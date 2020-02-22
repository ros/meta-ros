# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# tuw-nav-msgs/0.0.13-r0/git/src/route_segment.cpp:119:1: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
