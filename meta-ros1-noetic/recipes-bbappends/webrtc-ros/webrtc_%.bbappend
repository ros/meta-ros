# Copyright (c) 2020 LG Electronics, Inc.

# Fetches depot_tools during do_configure and then tries to use vpython which isn't in dependencies
#
# | -- Fetching depot_tools from Chromium
# | Cloning into 'depot_tools'...
# | -- Fetching Ninja build tool
# | -- Fetching WebRTC source code
# | /jenkins/mjansa/build-ros/ros1-melodic-thud/tmp-glibc/work/aarch64-oe-linux/webrtc/59.0.3-r0/git/build/depot_tools/vpython: line 42: /jenkins/mjansa/build-ros/ros1-melodic-thud/tmp-glibc/work/aarch64-oe-linux/webrtc/59.0.3-r0/git/build/depot_tools/.cipd_bin/vpython: No such file or directory
# | CMake Error at CMakeLists.txt:41 (message):
# |   cannot fetch WebRTC source code
