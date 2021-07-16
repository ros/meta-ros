require ${COREBASE}/meta/recipes-core/images/core-image-minimal.bb

SUMMARY = "An image with packagegroup-ros-world installed"
DESCRIPTION = "${SUMMARY}"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL:append = " \
    packagegroup-ros-world \
"
