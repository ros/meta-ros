require ${COREBASE}/meta/recipes-graphics/images/core-image-x11.bb

SUMMARY = "Desktop Full image of ROS 2"
DESCRIPTION = "The desktop_full variant provides a "batteries included" experience, enabling novice users to complete most entry tutorials without knowledge of the underlying library structure."
HOMEPAGE = "https://www.ros.org/reps/rep-2001.html"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL:append = " \
    desktop-full \
"
