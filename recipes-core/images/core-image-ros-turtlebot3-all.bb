# Copyright (c) 2019 LG Electronics, Inc.

require core-image-ros-roscore.bb

SUMMARY = "Core ROS image containing all TurtleBot 3 packages"
DESCRIPTION = "${SUMMARY}"

IMAGE_INSTALL_append = " \
    packagegroup-ros-turtlebot3-core \
    packagegroup-ros-turtlebot3-extended \
"
