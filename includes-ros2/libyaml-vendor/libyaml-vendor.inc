# Copyright (c) 2019 LG Electronics, Inc.

FILES_${PN}-dev_prepend = "${prefix}/cmake "
SYSROOT_DIRS_append = " ${prefix}/cmake"

PROVIDES_crystal += "libyaml"
RPROVIDES_${PN}_crystal += "libyaml"

PROVIDES_dashing += "libyaml"
RPROVIDES_${PN}_dashing += "libyaml"
