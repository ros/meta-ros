# Copyright (c) 2019 LG Electronics, Inc.

PNBLACKLIST[webos-image-ros-world] = "${@ 'Requires meta-webos layer' if 'meta-webos' not in BBFILE_COLLECTIONS.split() else '' }"

# Prevent error when parsing if meta-webos layer isn't present.
LICENSE = "Apache-2.0"
LAYERDIR_meta-webos = "${@(d.getVar('BBFILE_PATTERN_meta-webos', True) or '')[1:]}"
include ${LAYERDIR_meta-webos}/recipes-core/images/webos-image.bb

SUMMARY = "A webOS image with packagegroup-ros-world installed"
DESCRIPTION = "${SUMMARY}"

inherit ros_distro_${ROS_DISTRO}
inherit ${ROS_DISTRO_TYPE}_image

IMAGE_INSTALL_append = " \
    packagegroup-ros-world \
"
