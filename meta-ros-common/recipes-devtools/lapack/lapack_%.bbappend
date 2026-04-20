# Copyright (c) 2024 Wind River Systems, Inc.

# QA Issue: File /usr/lib/cmake/lapack-3.12.0/lapack-config.cmake in package lapack-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${libdir}/cmake/${PN}-*/lapack-config.cmake
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${libdir}/cmake/${PN}-*/lapack-targets.cmake
}

# Remove flags which are added via TARGET_CC_ARCH but are not valid for Fortran (FC)
FC:remove = "-Wformat"
FC:remove = "-Wformat-security"
FC:remove = "-Werror=format-security"

# Prevent lapack from building ILP64 when OpenBLAS is using LP64
# Resolves link-time errors related to missing symbols with suffix '_64_'
#   x86_64-oe-linux-ld: ../../lib/liblapack.so.3.12.0: undefined reference to `cdotc_64_'
EXTRA_OECMAKE += "\
  -DBUILD_INDEX64=OFF \
  -DBUILD_INDEX64_EXT_API=OFF \
"
