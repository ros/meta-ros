# Copyright (c) 2019 LG Electronics, Inc.
# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-pyyaml-native \
"
LICENSE = "BSD-3-Clause"

EXTRA_OECMAKE:append = " -DCMAKE_POLICY_VERSION_MINIMUM=3.5"

INSANE_SKIP:${PN}-dev += "buildpaths"
