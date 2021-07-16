# Copyright (c) 2020-2021 LG Electronics, Inc.

EXTRA_OECMAKE += "-DSPDLOG_BUILD_SHARED=on"

# Force to use gold just to prevent prelink from crashing due to bug in it
CXXFLAGS:append = " -fuse-ld=gold"
