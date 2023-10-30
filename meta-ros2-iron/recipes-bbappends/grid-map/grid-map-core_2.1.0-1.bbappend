# Copyright (c) 2022 Wind River Systems, Inc.

# grid-map-core/2.0.0-1-r0/git/src/Polygon.cpp:161:30: error: comparison of integer expressions of different signedness: 'unsigned int' and 'Eigen::Index' {aka 'int'} [-Werror=sign-compare]
# grid-map-core/2.0.0-1-r0/git/src/Polygon.cpp:169:32: error: comparison of integer expressions of different signedness: 'unsigned int' and 'Eigen::Index' {aka 'int'} [-Werror=sign-compare]
CXXFLAGS += "-Wno-error=sign-compare"
