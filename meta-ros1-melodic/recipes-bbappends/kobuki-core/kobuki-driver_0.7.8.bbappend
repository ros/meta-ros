# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# kobuki-driver/0.7.8-r0/git/src/driver/../../include/kobuki_driver/modules/acceleration_limiter.hpp:125:3: error: control reaches end of non-void function [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
