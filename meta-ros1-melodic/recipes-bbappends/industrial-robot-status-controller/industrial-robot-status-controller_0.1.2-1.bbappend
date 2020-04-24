# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# industrial-robot-status-controller/0.1.2-1-r0/git/src/controller.cpp:100:1: error: control reaches end of non-void function [-Werror=return-type]
# industrial-robot-status-controller/0.1.2-1-r0/git/src/controller.cpp:89:1: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
