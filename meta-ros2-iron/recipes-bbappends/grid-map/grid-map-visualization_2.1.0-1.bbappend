# Copyright (c) 2024 Wind River Systems, Inc.

# stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' forming offset 8 is out of the bounds [0, 8] [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"

# stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' writing between 9 and 9223372036854775807 bytes into a region of size 8 overflows the destination [-Werror=stringop-overflow=]
CXXFLAGS += "-Wno-error=stringop-overflow"
