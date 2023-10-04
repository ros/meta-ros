# Copyright (c) 2022 Acceleration Robotics S.L. <contact@accelerationrobotics.com>

# Without the target dependencies, ament finds the native packages and then fails to link (error: incompatible target).
ROS_BUILD_DEPENDS += " \
    python3-numpy-native \
"
