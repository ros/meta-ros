# Copyright (c) 2019 LG Electronics, Inc.

require recipes-core/images/webos-image.bb

SUMMARY = "ROS with webOS image containing all TurtleBot 3 packages"
DESCRIPTION = "${SUMMARY}"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL_append = " \
    packagegroup-ros-turtlebot3-core \
    packagegroup-ros-turtlebot3-extended \
"
