# Copyright (c) 2023 Wind River Systems, Inc.

ROS_BUILDTOOL_DEPENDS += " \
    python3-numpy-native \
"

inherit pkgconfig

EXTRA_OECMAKE = " \
    -DPYTHON_VERSION=${PYTHON_BASEVERSION} \
    -DPython3_VERSION=${PYTHON_BASEVERSION} \
"
