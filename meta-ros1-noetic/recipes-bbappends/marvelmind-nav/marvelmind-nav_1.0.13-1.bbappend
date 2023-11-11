# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# marvelmind-nav/1.0.11-1-r0/git/src/hedge_rcv_bin.cpp:108:26: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
