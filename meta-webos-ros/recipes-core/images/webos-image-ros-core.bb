# Copyright (c) 2019 LG Electronics, Inc.

require recipes-core/images/webos-image.bb

SUMMARY = "A webOS image just capable of starting core ROS."
DESCRIPTION = "${SUMMARY}"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL_append = " \
    ros-core \
"
