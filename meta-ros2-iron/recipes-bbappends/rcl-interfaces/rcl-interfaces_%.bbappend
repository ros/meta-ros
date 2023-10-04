# Copyright (c) 2023 Mission Robotics

inherit setuptools3-base

# Without this, the build fails with a 'file in wrong format' error as the 'service-msgs-native' gets found.
ROS_BUILDTOOL_DEPENDS:prepend = " \
    service-msgs \
"
