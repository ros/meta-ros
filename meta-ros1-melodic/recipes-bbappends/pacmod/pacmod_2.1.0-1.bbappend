# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# pacmod/2.1.0-1-r0/git/src/pacmod_ros_msg_handler.cpp:485:1: error: control reaches end of non-void function [-Werror=return-type]
# pacmod/2.1.0-1-r0/git/src/pacmod_ros_msg_handler.cpp:490:24: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
