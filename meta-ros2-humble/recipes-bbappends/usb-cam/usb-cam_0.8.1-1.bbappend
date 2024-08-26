# Copyright (c) 2021 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# usb-cam/0.4.0-1-r0/git/src/usb_cam.cpp:1083:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"

inherit pkgconfig
