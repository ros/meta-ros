DESCRIPTION = "A small image just capable of starting roslaunch."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image
inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_INSTALL:append = " roslaunch"
