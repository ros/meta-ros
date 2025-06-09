require ${COREBASE}/meta/recipes-graphics/images/core-image-x11.bb

SUMMARY = "Full desktop image of ROS 2"
DESCRIPTION = "${SUMMARY}"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL:append = " \
    ros-core \
    desktop-full \
"
