# Copyright (c) 2020 LG Electronics, Inc.

DEPENDS += "pilz-industrial-motion-testutils"

do_configure_append() {
    # Fixes this:
    # pilz-trajectory-generation/0.4.10-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cmath:45:15: fatal error: math.h: No such file or directory
    # pilz-trajectory-generation/0.4.10-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cstdlib:75:15: fatal error: stdlib.h: No such file or directory
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}
