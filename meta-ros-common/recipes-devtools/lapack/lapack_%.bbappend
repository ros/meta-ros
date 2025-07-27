# Copyright (c) 2024 Wind River Systems, Inc.

# QA Issue: File /usr/lib/cmake/lapack-3.12.0/lapack-config.cmake in package lapack-dev contains reference to TMPDIR [buildpaths]
do_install:append() {
    sed -i -e "s#${RECIPE_SYSROOT}##g" ${D}${libdir}/cmake/${PN}-*/lapack-config.cmake
}
