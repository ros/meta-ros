# Copyright (c) 2020 LG Electronics, Inc.

# Fails with webOS OSE which by default uses -Werror=return-type
# costmap-converter/0.0.12-1-r0/git/include/costmap_converter/costmap_to_polygons.h:305:5: error: no return statement in function returning non-void [-Werror=return-type]
CXXFLAGS += "-Wno-error=return-type"
