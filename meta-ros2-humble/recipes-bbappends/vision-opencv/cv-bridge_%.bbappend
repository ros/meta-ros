# Copyright (c) 2020 LG Electronics, Inc.
# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# Fix for Honister release only:
inherit distutils3-base

ROS_BUILD_DEPENDS:remove = "python-numpy"
ROS_BUILD_DEPENDS:remove = "python3-numpy"

ROS_BUILDTOOL_DEPENDS += " \
    ${PYTHON_PN}-numpy-native \
"
