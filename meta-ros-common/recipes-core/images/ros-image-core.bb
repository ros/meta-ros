require ${COREBASE}/meta/recipes-core/images/core-image-minimal.bb

SUMMARY = "A small image just capable of starting core ROS."
DESCRIPTION = "${SUMMARY}"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL:append = " \
    ros-core \
"

# The deploy code requires bash and
# normal linux utilities not busybox ones.
# See https://github.com/ros/meta-ros/issues/1068#issuecomment-1908098993
CORE_IMAGE_EXTRA_INSTALL += "\
    bash coreutils util-linux tar gzip bzip2 kmod \
    python3-modules python3-misc \
    e2fsprogs e2fsprogs-mke2fs parted \
    "