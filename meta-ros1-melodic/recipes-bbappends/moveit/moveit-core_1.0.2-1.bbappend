# Copyright (c) 2020 LG Electronics, Inc.

do_configure_append() {
    # Fixes this:
    # moveit-core/1.0.2-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cmath:45:15: fatal error: math.h: No such file or directory
    # moveit-core/1.0.2-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cstdlib:75:15: fatal error: stdlib.h: No such file or directory
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}

# angles dependency should be used only when catkin testing
# is enabled, which in our builds isn't
FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"
SRC_URI += "file://0001-trajectory_processing-remove-unnecessary-angles-angl.patch"
