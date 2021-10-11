# Copyright (c) 2021 LG Electronics, Inc.

DEPENDS += " \
    ament-package-native \
    python3-catkin-pkg-native \
"

FILES:${PN} += "${libdir}/python"
