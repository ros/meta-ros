# Metadata common to all ROS images.
#
# Copyright (c) 2019 LG Electronics, Inc.

# Allow images of different ROS_DISTRO-s to be distinguished.
ROS_IMAGE_BASENAME_APPEND ??= "-${ROS_DISTRO}"
IMAGE_BASENAME_append = "${ROS_IMAGE_BASENAME_APPEND}"
# Not sure why this is now needed ...
PROVIDES += "${IMAGE_BASENAME}"
