# Copyright (c) 2020 LG Electronics, Inc.

# Depends on cob-generic-can->libntcan with this restriction
COMPATIBLE_MACHINE = "(^$)"
COMPATIBLE_MACHINE:x86-64 = "(.*)"
COMPATIBLE_MACHINE:x86 = "(.*)"
