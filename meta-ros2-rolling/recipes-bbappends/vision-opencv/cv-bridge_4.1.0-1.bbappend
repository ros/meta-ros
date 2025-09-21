# Copyright (c) 2020 LG Electronics, Inc.

ROS_BUILD_DEPENDS:remove = "python-numpy"
ROS_BUILD_DEPENDS:remove = "python3-numpy"

LICENSE = "Apache-2.0 & BSD-3-Clause"

ROS_BUILDTOOL_DEPENDS += "\
    ${PYTHON_PN}-numpy-native \
"
