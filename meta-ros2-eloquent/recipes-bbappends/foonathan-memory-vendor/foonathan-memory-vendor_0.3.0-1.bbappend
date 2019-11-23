# Copyright (c) 2019 LG Electronics, Inc.

ROS_BUILD_DEPENDS += " \
    foonathan-memory \
"

_LICENSE := "${LICENSE}"
LICENSE = "${@'${_LICENSE}'.replace('zlib-License', 'Zlib')}"
