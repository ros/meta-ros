# Copyright (c) 2020 LG Electronics, Inc.

do_configure_append() {
    # Fixes this:
    # | fatal error: stdlib.h: No such file or directory
    # |   #include_next <stdlib.h>
    sed -i 's/-isystem /-I/g' ${B}/build.ninja
}
