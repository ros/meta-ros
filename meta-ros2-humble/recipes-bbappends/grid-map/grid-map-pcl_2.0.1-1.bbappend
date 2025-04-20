# Copyright (c) 2024 Wind River Systems, Inc.

# grid-map-pcl/2.0.0-1-r0/recipe-sysroot/usr/include/pcl-1.10/pcl/octree/octree_key.h:147:12: error: ISO C++ prohibits anonymous structs [-Werror=pedantic]
CXXFLAGS += "-Wno-error=pedantic"

# stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' forming offset 8 is out of the bounds [0, 8] [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"

# stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' writing between 9 and 9223372036854775807 bytes into a region of size 8 overflows the destination [-Werror=stringop-overflow=]
CXXFLAGS += "-Wno-error=stringop-overflow"
