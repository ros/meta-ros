# Copyright (c) 2020 LG Electronics, Inc.

PNBLACKLIST[realsense-ros2-camera] ?= "${@bb.utils.contains_any('ROS_WORLD_SKIP_GROUPS', ['opengl', 'glfw'], 'opengl: depends on librealsense2->mesa which is not available because of missing opengl or vulkan in DISTRO_FEATURES; glfw: Depends on librealsense2->glfw which is not available in zeus and older', '', d)}"
