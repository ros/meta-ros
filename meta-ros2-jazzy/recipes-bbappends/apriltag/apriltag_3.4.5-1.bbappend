# Copyright (c) 2020-2021 LG Electronics, Inc.

LICENSE = "BSD-2-Clause"

inherit ros_insane_dev_so python3targetconfig

DEPENDS += "python3-numpy-native"

CFLAGS += "-Wno-error=pedantic"
