DESCRIPTION = "Image for testing meta-ros' SDK feature"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_FEATURES += "ssh-server-openssh"

IMAGE_INSTALL += "roslaunch rostopic roscpp-dev std-msgs-dev"

TOOLCHAIN_HOST_TASK += "nativesdk-cmake nativesdk-catkin"
