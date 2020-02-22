# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# microstrain-mips/0.0.3-1-r0/git/include/microstrain_mips/microstrain_3dm.h:94:24: error: control reaches end of non-void function [-Werror=return-type]
# microstrain-mips/0.0.3-1-r0/git/src/microstrain_3dm.cpp:3135:3: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
