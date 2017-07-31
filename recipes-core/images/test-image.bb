DESCRIPTION = "A small image just capable of starting roscore."

IMAGE_INSTALL = "packagegroup-core-boot ${ROOTFS_PKGMANAGE_BOOTSTRAP} ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

IMAGE_ROOTFS_SIZE = "8192"

IMAGE_INSTALL += " \
    catkin-runtime \
    roslaunch \
    roscpp \
    rospy \
"

# IMAGE_INSTALL += "sshd"

################################################################################

TOOLCHAIN_HOST_TASK += "nativesdk-catkin"
