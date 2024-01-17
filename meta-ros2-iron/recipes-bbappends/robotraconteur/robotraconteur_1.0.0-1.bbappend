# Copyright (c) 2023 Wind River Systems, Inc.

inherit python3native

ROS_BUILDTOOL_DEPENDS += " \
    python3-numpy-native \
"

EXTRA_OECMAKE = "-DBUILD_TESTING=OFF -DSETUPTOOLS_DEB_LAYOUT=OFF"

FILES:${PN} += "${datadir}/ament_index/resource_index/packages/robotraconteur"
