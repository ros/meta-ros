require ${COREBASE}/meta/recipes-graphics/images/core-image-x11.bb

SUMMARY = "Desktop image of ROS 2"
DESCRIPTION = "The desktop variant provides all commonly used libraries as well as visualization tools and tutorials."
HOMEPAGE = "https://www.ros.org/reps/rep-2001.html"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL:append = " \
    desktop \
"
