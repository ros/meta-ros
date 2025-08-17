# Copyright (c) 2019 LG Electronics, Inc.

inherit ros_image

TOOLCHAIN_HOST_TASK:append = " ${ROS_SDK_HOST_PACKAGES}"
TOOLCHAIN_TARGET_TASK:append = " ${ROS_SDK_TARGET_PACKAGES}"

# Place metadata unique to ROS 2 images here.
