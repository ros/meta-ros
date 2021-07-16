# Metadata common to all ROS images.
#
# Copyright (c) 2019 LG Electronics, Inc.

# Allow images of different ROS_DISTRO-s to be distinguished.
ROS_IMAGE_BASENAME_APPEND ??= "-${ROS_DISTRO}"
IMAGE_BASENAME:append = "${ROS_IMAGE_BASENAME_APPEND}"
# XXX Not sure why this is now needed ...
PROVIDES += "${IMAGE_BASENAME}"

# See https://github.com/agherzan/meta-raspberrypi/blob/master/docs/layer-contents.md -- but why aren't they always included by
# meta-raspberrypi?
IMAGE_INSTALL:append:rpi = " \
    ${MACHINE_EXTRA_RRECOMMENDS} \
"

# XXX (add description)
IMAGE_FEATURES[validitems] += "ros-implicit-workspace"
COMPLEMENTARY_GLOB[ros-implicit-workspace] = "*-implicitworkspace"
