# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

ROS_BUILDTOOL_DEPENDS += " \
    python3-numpy-native \
"
# Fix for Honister release only:
inherit distutils3-base
