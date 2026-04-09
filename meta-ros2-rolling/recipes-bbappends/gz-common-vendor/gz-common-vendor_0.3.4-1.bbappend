# Copyright (c) 2024 Wind River Systems, Inc.

ROS_BUILD_DEPENDS += "gz-common6"

FILES:${PN}-dev =+ "${ros_libdir}/lib*${SOLIBSDEV}"

BBCLASSEXTEND = "native nativesdk"
