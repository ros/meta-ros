# Copyright (c) 2023-2024 Wind River Systems, Inc.

# apriltag-ros/3.1.2-1-r0/recipe-sysroot/usr/include/apriltag/common/matd.h:48:12: error: ISO C++ forbids flexible array member 'data' [-Werror=pedantic]
CXXFLAGS += "-Wno-error=pedantic"

# apriltag-ros/3.1.2-1/recipe-sysroot/usr/include/c++/13.2.0/bits/stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' forming offset 8 is out of the bounds [0, 8] [-Werror=array-bounds=]
CXXFLAGS += "-Wno-error=array-bounds"

# apriltag-ros/3.1.2-1/recipe-sysroot/usr/include/c++/13.2.0/bits/stl_algobase.h:437:30: error: 'void* __builtin_memmove(void*, const void*, long unsigned int)' writing between 9 and 9223372036854775807 bytes into a region of size 8 overflows the destination [-Werror=stringop-overflow=]
CXXFLAGS += "-Wno-error=stringop-overflow"

# tf2/convert.h is intentionally obsolete and triggers a warning (fatal under -Werror)
do_configure:append() {
    sed -i \
      -e 's#<tf2/convert.h>#<tf2/convert.hpp>#g' \
      ${S}/src/pose_estimation.cpp \
      ${S}/src/conversion.cpp
}
