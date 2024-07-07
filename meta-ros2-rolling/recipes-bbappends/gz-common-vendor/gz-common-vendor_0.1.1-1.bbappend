# Copyright (c) 2024 Wind River Systems, Inc.

export GZ_RELAX_VERSION_MATCH="1"

ROS_BUILD_DEPENDS += "gz-common5"

FILES:${PN}-dev =+ "${ros_libdir}/lib*${SOLIBSDEV}"

BBCLASSEXTEND = "native nativesdk"
