# Copyright (c) 2023 Mission Robotics

inherit setuptools3-base

# Without this, the build fails with a 'file in wrong format' error as the 'action-msgs-native' gets found.
ROS_BUILDTOOL_DEPENDS:prepend = " \
    action-msgs \
"
