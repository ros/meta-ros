# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# dynamixel-workbench-single-manager/2.0.0-r0/git/src/single_dynamixel_controller.cpp:115:46: error: control reaches end of non-void function [-Werror=return-type]
# dynamixel-workbench-single-manager/2.0.0-r0/git/src/single_dynamixel_controller.cpp:258:1: error: control reaches end of non-void function [-Werror=return-type]
# dynamixel-workbench-single-manager/2.0.0-r0/git/src/single_dynamixel_controller.cpp:38:1: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
