# Copyright (c) 2019 LG Electronics, Inc.

FILES_${PN}-dev_prepend = "${prefix}/cmake "
SYSROOT_DIRS_append = " ${prefix}/cmake"

PROVIDES += "libyaml"
RPROVIDES_${PN} += "libyaml"
