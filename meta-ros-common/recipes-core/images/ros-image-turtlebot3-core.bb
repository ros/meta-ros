# Copyright (c) 2019 LG Electronics, Inc.

require ros-image-core.bb

SUMMARY = "Core ROS image containing core TurtleBot 3 packages"
DESCRIPTION = "${SUMMARY}"
LICENSE = "MIT"

IMAGE_INSTALL:append = " \
    packagegroup-ros-turtlebot3-core \
"
