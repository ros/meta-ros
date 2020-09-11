# Copyright (c) 2020 LG Electronics, Inc.

# CMake Error: TRY_RUN() invoked in cross-compiling mode, please set the following cache variables appropriately:
#   HAS_LTO_EXITCODE (advanced)
#   HAS_LTO_EXITCODE__TRYRUN_OUTPUT (advanced)
EXTRA_OECMAKE += "-DHAS_LTO_EXITCODE=1 -DHAS_LTO_EXITCODE__TRYRUN_OUTPUT=0"

# Otherwise it tries to build own version with ExternalProject_Add and fails
# ninja: error: 'lib/liboctomath.a', needed by 'lib/libmrpt-maps.so.2.0.4', missing and no known rule to make it
DEPENDS += "octomap"
