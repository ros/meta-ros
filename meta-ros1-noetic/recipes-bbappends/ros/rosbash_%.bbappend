# Copyright (c) 2019 LG Electronics, Inc.

# "rosrun" uses array variables, so we can't use the BASH provided by "busybox" but must use a "real" one. NB. "busybox" is only
# present on the target. The "bash" package installs one, and /usr/bin/env finds it.
do_install:append:class-target() {
    sed -i -e '1 s@^.*$@#!/usr/bin/env bash@' ${D}${ros_bindir}/rosrun
}

RDEPENDS:${PN}:append:class-target = " bash"
