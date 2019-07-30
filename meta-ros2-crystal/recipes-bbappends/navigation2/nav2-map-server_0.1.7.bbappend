# Copyright (c) 2019 LG Electronics, Inc.

# bullet appears in both ROS_BUILD_DEPENDS and ROS_EXPORT_DEPENDS, so it's easier to remove it from DEPENDS.
DEPENDS_remove = "bullet"
ROS_EXEC_DEPENDS_remove = "bullet"

FILESEXTRAPATHS_prepend := "${THISDIR}/${BPN}:"

SRC_URI += " \
    file://0001-removed-bullet-dependency-from-map_server-594.patch \
    file://0002-Fix-build-with-catching-polymorphic-type-error.patch \
"
