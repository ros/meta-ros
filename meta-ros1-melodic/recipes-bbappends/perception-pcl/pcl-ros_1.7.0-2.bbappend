# Copyright (c) 2019 LG Electronics, Inc.

# Fixes this:
# | fatal error: stdlib.h: No such file or directory
# |   #include_next <stdlib.h>
do_configure_append() {
    if [ -e ${B}/build.ninja ]; then
        sed -i -e 's/-isystem /-I/g' ${B}/build.ninja
    else
        grep -rl -- '-isystem ' ${B} | xargs sed -i -e 's/-isystem /-I/g'
    fi
}
