# Copyright (c) 2020 LG Electronics, Inc.

# Rdepends on schunk-sdh which depends on libntcan with this restriction
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
COMPATIBLE_MACHINE:x86 = "(.*)"
