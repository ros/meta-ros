# Copyright (c) 2019 LG Electronics, Inc.

require ros-image-core.bb

SUMMARY = "Core ROS image containing all TurtleBot 3 packages"
DESCRIPTION = "${SUMMARY}"

IMAGE_INSTALL:append = " \
    packagegroup-ros-turtlebot3-core \
    packagegroup-ros-turtlebot3-extended \
"
