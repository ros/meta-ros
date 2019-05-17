# ubuntu-bionic/ros-distro-platform-recipe-blacklist.inc
#
# Copyright (c) 2019 LG Electronics, Inc.

# Initially, blacklist any platform duplicates found by "bitbake-layers show-overlayed". Remove from the blacklist once a
# PREFERRED_VERSION_<PN> setting is made in ros-distro-platform-preferred-versions.inc .
PNBLACKLIST[cppunit] ?= "Must specify PREFERRED_VERSION"
PNBLACKLIST[python-matplotlib] ?= "Must specify PREFERRED_VERSION"

# Initially, blacklist any platform recipes with multiple versions found by "bitbake-layers show-recipes --multiple" (except for
# the compilers and runtimes). Remove from the blacklist once a PREFERRED_VERSION_<PN> setting is made in
# ros-distro-platform-preferred-versions.inc .
PNBLACKLIST[libgpiod] ?= "Must specify PREFERRED_VERSION"
PNBLACKLIST[libmodbus] ?= "Must specify PREFERRED_VERSION"
PNBLACKLIST[linux-yocto-rt] ?= "Must specify PREFERRED_VERSION"
PNBLACKLIST[linux-yocto-tiny] ?= "Must specify PREFERRED_VERSION"
PNBLACKLIST[php] ?= "Must specify PREFERRED_VERSION"
PNBLACKLIST[php-native] ?= "Must specify PREFERRED_VERSION"
PNBLACKLIST[yajl] ?= "Must specify PREFERRED_VERSION"
