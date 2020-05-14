# Copyright (c) 2020 LG Electronics, Inc.

do_configure_append() {
    # Fixes this:
    # robot-body-filter/1.1.6-1-r0/recipe-sysroot/usr/include/c++/8.2.0/cstdlib:75:15: fatal error: stdlib.h: No such file or directory #include_next <stdlib.h>
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}
