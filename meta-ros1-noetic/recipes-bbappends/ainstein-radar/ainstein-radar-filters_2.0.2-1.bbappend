# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# ainstein-radar-filters/2.0.2-1-r0/git/include/ainstein_radar_filters/radar_target_kf.h:126:2: error: no return statement in function returning non-void [-Werror=return-type]
# ainstein-radar-filters/2.0.2-1-r0/git/include/ainstein_radar_filters/radar_target_kf.h:58:2: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
